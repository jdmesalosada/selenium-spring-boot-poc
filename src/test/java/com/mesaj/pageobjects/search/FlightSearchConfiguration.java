package com.mesaj.pageobjects.search;

import org.openqa.selenium.WebDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightSearchConfiguration {

    @Bean
    @ConditionalOnProperty(name = "flight.search.type", havingValue = "advanced")
    public FlightSearchComponent advancedFlightSearchComponent(WebDriver driver){
        return new AdvancedFlightSearchComponent(driver);
    }

    @Bean
    @ConditionalOnProperty(name = "flight.search.type", havingValue = "basic")
    public FlightSearchComponent basicFlightSearchComponent(WebDriver driver){
        return new BasicFlightSearchComponent(driver);
    }
}
