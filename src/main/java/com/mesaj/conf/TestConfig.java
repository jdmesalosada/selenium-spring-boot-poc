package com.mesaj.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.mesaj")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class TestConfig {
}
