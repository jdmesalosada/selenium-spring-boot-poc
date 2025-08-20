package com.mesaj.pageobjects.search;

import com.mesaj.models.SearchInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicFlightSearchComponent implements FlightSearchComponent{
    
    @FindBy(id = "basic-origin")
    private WebElement originInput;

    @FindBy(id = "basic-destination")
    private WebElement destinationInput;

    @FindBy(id = "basic-passengers")
    private WebElement passengersInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @Autowired
    public BasicFlightSearchComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public void searchFlight(SearchInfo searchInfo) {

        originInput.sendKeys(searchInfo.origin());
        destinationInput.sendKeys(searchInfo.destination());
        passengersInput.sendKeys(String.valueOf(searchInfo.numberOfPassengers()));
        searchButton.click();
    }
}
