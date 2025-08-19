package com.mesaj.conf;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DriverFactory {

    public WebDriver get(String browser){
        if("chrome".equals(browser)){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
            return new ChromeDriver(chromeOptions);
        }
        else if("firefox".equals(browser)){
            return new FirefoxDriver();
        }
        else{
            throw new InvalidArgumentException("No valid browser: " + browser);
        }
    }
}
