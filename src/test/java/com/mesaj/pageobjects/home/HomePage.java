package com.mesaj.pageobjects.home;

import com.mesaj.models.SearchInfo;
import com.mesaj.pageobjects.search.FlightSearchComponent;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class HomePage {

    private final FlightSearchComponent flightSearchComponent;
    private final WebDriver driver;

    public HomePage(WebDriver driver, FlightSearchComponent flightSearchComponent) {
        this.driver = driver;
        this.flightSearchComponent = flightSearchComponent;
    }

    public void navigate(String type) {
        URL resourceUrl = getClass().getClassLoader().getResource("flightsearch.html");
        if(resourceUrl != null){
            String fullUrl = resourceUrl + "?type=" + type;
            driver.get(fullUrl);
        }
        else{
            throw new RuntimeException("Could not find the flightsearch.html file");
        }
    }

    public void performSearch(SearchInfo searchInfo) {
        this.flightSearchComponent.searchFlight(searchInfo);
    }

}
