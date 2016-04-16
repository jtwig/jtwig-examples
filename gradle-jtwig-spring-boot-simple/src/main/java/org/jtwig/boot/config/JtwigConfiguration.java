package org.jtwig.boot.config;

import org.jtwig.configuration.ConfigurationBuilder;
import org.jtwig.functions.SimpleFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JtwigConfiguration {
    @Bean
    public ConfigurationBuilder configurationBuilder () {
        return ConfigurationBuilder.configuration()
                .include(new SimpleFunction() {
                    @Override
                    public String name() {
                        return "newFunction";
                    }

                    @Override
                    public Object execute(Object... objects) {
                        return objects[0].toString().toUpperCase();
                    }
                })
                ;
    }
}
