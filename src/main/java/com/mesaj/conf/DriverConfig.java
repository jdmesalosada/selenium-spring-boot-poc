package com.mesaj.conf;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfig {

    @Autowired
    private DriverFactory driverFactory;

    @Value("${browser}")
    private String browser;

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(){
        return driverFactory.get(browser);
    }
}
