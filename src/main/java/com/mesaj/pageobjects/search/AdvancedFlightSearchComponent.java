package com.mesaj.pageobjects.search;

import com.mesaj.models.SearchInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvancedFlightSearchComponent implements FlightSearchComponent {

    @FindBy(id = "adv-origin")
    private WebElement originInput;

    @FindBy(id = "adv-destination")
    private WebElement destinationInput;

    @FindBy(id = "adv-passengers")
    private WebElement passengersInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @Autowired
    public AdvancedFlightSearchComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public void searchFlight(SearchInfo searchInfo) {

        Select selectOrigin = new Select(originInput);
        selectOrigin.selectByVisibleText(searchInfo.origin());

        Select selectDestination = new Select(destinationInput);
        selectDestination.selectByVisibleText(searchInfo.destination());

        Select selectPassengers = new Select(passengersInput);
        selectPassengers.selectByVisibleText(String.valueOf(searchInfo.numberOfPassengers()));

        searchButton.click();
    }
}
