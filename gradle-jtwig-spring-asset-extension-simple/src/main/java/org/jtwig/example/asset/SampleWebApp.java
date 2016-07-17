package org.jtwig.example.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class SampleWebApp {
    public static void main(String[] args) {
        SpringApplication.run(SampleWebApp.class, args);
    }
}
