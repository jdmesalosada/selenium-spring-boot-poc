package com.mesaj.pageobjects.home;

import com.mesaj.models.SearchInfo;
import com.mesaj.pageobjects.search.FlightSearchComponent;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class HomePage {

    private final FlightSearchComponent flightSearchComponent;
    private final WebDriver driver;

    @Autowired
    private ResourceLoader resourceLoader;

    public HomePage(WebDriver driver, FlightSearchComponent flightSearchComponent) {
        this.driver = driver;
        this.flightSearchComponent = flightSearchComponent;
    }

    public void navigate(String type) {
        Resource resource = resourceLoader.getResource("classpath:flightsearch.html");

        String fileUrl = "";
        try{
            fileUrl = resource.getFile().toURI() + "?type=" + type;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.get(fileUrl);
    }

    public void performSearch(SearchInfo searchInfo) {
        this.flightSearchComponent.searchFlight(searchInfo);
    }

}
