package com.onejava.airportmanagement;

import com.github.mongobee.Mongobee;
import com.onejava.airportmanagement.dbconverters.AircraftDbReadConverter;
import com.onejava.airportmanagement.dbconverters.AircraftDbWriteConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

/*
1. Spring Application's entry point.
2. Added Custom converters configuration in order to register the converters.
3. Here Comment @Bean to unregister converter
 */
@SpringBootApplication
public class AirportManagementServiceApplication {
	/*
	For Data migration
	 */
	private final Environment environment;
	private final MongoTemplate mongoTemplate;

	public AirportManagementServiceApplication(Environment environment, MongoTemplate mongoTemplate) {
		this.environment = environment;
		this.mongoTemplate = mongoTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportManagementServiceApplication.class, args);
	}

	/*
	Custom converters configuration. We can add it here or we can create new class and annotate it with @Configuration
	 */
	//@Bean  // Comment this to unregister converter.
	public MongoCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new AircraftDbReadConverter());
		converters.add(new AircraftDbWriteConverter());
		return new MongoCustomConversions(converters);
	}

	/*
	For Data migration
	 *//*
	@Bean
	public Mongobee mongobee() {
		String mongoUri = environment.getProperty("spring.data.mongodb.uri");
		boolean migrationsEnabled = Boolean.parseBoolean(environment.getProperty("app.db.migrations.enabled"));
		Mongobee runner = new Mongobee(mongoUri);
		runner.setEnabled(migrationsEnabled);
		runner.setChangeLogsScanPackage("com.onejava.airportmanagement.dbmigrations");
		runner.setChangelogCollectionName("migrations");
		runner.setLockCollectionName("migrations_lock");
		runner.setMongoTemplate(mongoTemplate);
		return runner;
	}*/
}
