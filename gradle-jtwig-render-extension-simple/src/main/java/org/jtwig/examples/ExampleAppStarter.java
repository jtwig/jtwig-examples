package org.jtwig.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ExampleAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(ExampleAppStarter.class);
    }
}
