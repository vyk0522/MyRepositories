package com.onejava.service.stream;

import com.onejava.service.EvaluatePriceLoggerServiceApplication;
import com.onejava.service.model.NTVProductDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NtvPriceLogger {
    private static Logger logger = LoggerFactory.getLogger(EvaluatePriceLoggerServiceApplication.class);

    @Bean
    public Consumer<NTVProductDetail> process() {
        return ntvProductDetail -> logger.info(ntvProductDetail.toString());
    }
}
