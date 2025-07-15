package com.mesaj.pageobjects.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class SearchResult {

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement successAlert;

    private final WebDriver driver;

    @Autowired
    public SearchResult(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkSuccessResult(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> successAlert.isDisplayed());
    }
}
