package com.onejava.service;

import com.onejava.domain.UsageCostDetail;
import com.onejava.model.UsageCostResponse;
import com.onejava.repository.UsageCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsageCostService {
    @Autowired
    private UsageCostRepository repository;

    public UsageCostResponse getCallConversionValue(String type, String offer){
        return repository.findByTypeAndOffer(type, offer);
    }

    public UsageCostDetail createCallPlan(UsageCostDetail request){
        return repository.save(request);
    }
}
