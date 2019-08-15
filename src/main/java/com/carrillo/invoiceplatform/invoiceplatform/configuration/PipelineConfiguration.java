package com.carrillo.invoiceplatform.invoiceplatform.configuration;

import handlers.Handler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pipeline.IPipeline;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PipelineConfiguration {

    @Bean(name = "reportPipeline")
    public IPipeline reportPipeline(@Qualifier("getUserHandler") Handler getUserHandler){
        List<Handler> handlers = new ArrayList<>();
        handlers.add(getUserHandler);
        return new IPipeline(handlers);
    }

    @Bean(name = "saveUserPipeline")
    public IPipeline saveUserPipeline(@Qualifier("saveUserHandler")Handler saveUserHandler){
        List<Handler> handlers = new ArrayList<>();
        handlers.add(saveUserHandler);
        return new IPipeline(handlers);
    }

    @Bean(name = "getUserPipeline")
    public IPipeline getUserPipeline(@Qualifier("getUserHandler")Handler getUserHandler){
        List<Handler> handlers = new ArrayList<>();
        handlers.add(getUserHandler);
        return new IPipeline(handlers);
    }
}
