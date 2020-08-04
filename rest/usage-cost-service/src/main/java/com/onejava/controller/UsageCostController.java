package com.onejava.controller;

import com.onejava.domain.UsageCostDetail;
import com.onejava.model.UsageCostResponse;
import com.onejava.service.UsageCostService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/call")
@Log
public class UsageCostController {
    @Autowired
    private UsageCostService service;

    @GetMapping("/v1/{type}/{offer}")
    public UsageCostResponse getCallConversion(@PathVariable String type, @PathVariable String offer){
        UsageCostResponse callUsageValue = service.getCallConversionValue(type, offer);
        log.info(callUsageValue.toString());
        return callUsageValue;
    }

    @PostMapping("/")
    public UsageCostDetail createCallPlan(@RequestBody UsageCostDetail usageCostDetail){
        return service.createCallPlan(usageCostDetail);
    }
}
