package org.jtwig.example.config;

import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Profile("!dev")
@Configuration
public class ProductionWebConfig extends WebMvcConfigurerAdapter implements JtwigViewResolverConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/client/**")
                .addResourceLocations("classpath:/client/");
    }

    @Override
    public void configure(JtwigViewResolver viewResolver) {
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".twig.html");
    }
}
