package org.jtwig.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class AppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppMain.class)
                .profiles("dev")
                .run(args);
    }
}
