package org.jtwig.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class WebAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(WebAppStarter.class);
    }
}
