package org.jtwig.boot.config;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.extension.Extension;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.annotation.Configuration;

import static org.jtwig.environment.EnvironmentConfigurationBuilder.configuration;

@Configuration
public class JtwigConfig implements JtwigViewResolverConfigurer {
    @Override
    public void configure(JtwigViewResolver viewResolver) {
        viewResolver.setRenderer(new JtwigRenderer(configuration()
                .extensions().add(new MyExtension()).and()
                .build()));
    }

    private static class MyExtension implements Extension {
        @Override
        public void configure(EnvironmentConfigurationBuilder configurationBuilder) {
            System.out.println("Hi");
        }
    }
}
