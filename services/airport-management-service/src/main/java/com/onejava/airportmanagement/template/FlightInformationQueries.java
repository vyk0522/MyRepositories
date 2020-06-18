package com.onejava.airportmanagement.template;

import com.onejava.airportmanagement.domain.FlightInformation;
import com.onejava.airportmanagement.domain.FlightType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;

/*
1. Find all flights with paging and sorting
2. Find by Flight ID.
3. Count all international flights
4. Find all Flights by departure city.
5. Find all Flights by duration between min and max.
6. Find all Flights delayed at a particular departure city.
7. Find all flights that are on time and relate to a city.
8. Find by aircraft model.
9. Find by free text.
10. Batch Update isDelayed and duration fields for given destination.
11. Batch Delete for FlightsWithDurationLessThanTwoHours.
 */
@Service
public class FlightInformationQueries {
    private MongoTemplate mongoTemplate;

    public FlightInformationQueries(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /*
        1. Find all flights with paging and sorting
         */
    public List<FlightInformation> findAllFlights(String field,
                                           int pageNb,
                                           int pageSize) {
        Query allPagedAndOrdered = new Query().with(Sort.by(Sort.Direction.ASC, field)).with(PageRequest.of(pageNb, pageSize));
        return mongoTemplate.find(allPagedAndOrdered, FlightInformation.class);
    }

    /*
    2. Find by Flight ID.
     */
    public FlightInformation findSingleById(String id) {
        return mongoTemplate.findById(id, FlightInformation.class);
    }

    /*
    3. Count all international flights
     */
    public long countInternational() {
        Query international = Query.query(Criteria.where("type").is(FlightType.International));
        return mongoTemplate.count(international, FlightInformation.class);
    }

    /*
    4. Find all Flights by departure city.
     */
    public List<FlightInformation> findByDeparture(String departure) {
        Query byDeparture = new Query().addCriteria(Criteria.where("departure").is(departure));
        return mongoTemplate.find(byDeparture, FlightInformation.class);
    }

    /*
    5. Find all Flights by duration between min and max.
     */
    public List<FlightInformation> findByDurationBetween(int minMinutes,
                                                         int maxMinutes) {
        Query byDurationBetween = Query
                .query(Criteria.where("durationMin").gte(minMinutes).lte(maxMinutes))
                .with(Sort.by(Sort.Direction.DESC, "durationMin"));
        return mongoTemplate.find(byDurationBetween, FlightInformation.class);
    }

    /*
    6. Find all Flights delayed at a particular departure city.
     */
    public List<FlightInformation> findDelayedAtDeparture(String departure) {
        Query delayedAtDeparture = Query.query(Criteria.where("isDelayed").is(true).and("departure").is(departure));
        return mongoTemplate.find(delayedAtDeparture, FlightInformation.class);
    }

    /*
    7. Find all flights that are on time and relate to a city.
     */
    public List<FlightInformation> findRelatedToCityAndNotDelayed(String city) {
        Query byCity = Query.query(
                new Criteria()
                        .orOperator(
                                Criteria.where("departure").is(city),
                                Criteria.where("destination").is(city))
                        .andOperator(
                                Criteria.where("isDelayed").is(false)
                        )
        );

        return mongoTemplate.find(byCity, FlightInformation.class);
    }

    /*
    8. Find by aircraft model.
     */
    public List<FlightInformation> findByAircraft(String aircraft) {
        Query byAircraft = Query.query(Criteria.where("aircraft.model").is(aircraft));
        return mongoTemplate.find(byAircraft, FlightInformation.class);
    }

    /*
    9. Find by free text.
     */
    public List<FlightInformation> findByFreeText(String text) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
        Query byFreeText = TextQuery.queryText(textCriteria).sortByScore().with(PageRequest.of(0, 3));
        return mongoTemplate.find(byFreeText, FlightInformation.class);
    }

    /*
    10. Batch Update isDelayed field for given destination.
     */
    public void updateAllFlightsToDestinationAsDelayed(String dest) {
        Query departingFromRome = Query.query(Criteria.where("destination").is(dest));
        //Update setDelayed = Update.update("isDelayed", true);  // To update Single field
        Update update = new Update(); // To update multiple fields
        update.set("isDelayed", true);
        update.set("duration", 522);
        mongoTemplate.updateMulti(departingFromRome, update, FlightInformation.class);
    }

    /*
    11. Batch Delete for FlightsWithDurationLessThanTwoHours
     */
    public void removeFlightsWithDurationLessThanTwoHours() {
        Query lessThanTwoHours = Query.query(Criteria.where("duration").lt(120));
        mongoTemplate.findAllAndRemove(lessThanTwoHours, FlightInformation.class);
    }
}
