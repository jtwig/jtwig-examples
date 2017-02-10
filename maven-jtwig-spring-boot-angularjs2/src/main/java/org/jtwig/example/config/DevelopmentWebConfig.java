package org.jtwig.example.config;

import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.hot.reloading.HotReloadingExtension;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Profile("dev")
@Configuration
public class DevelopmentWebConfig extends WebMvcConfigurerAdapter implements JtwigViewResolverConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/client/**")
                .addResourceLocations(String.format("file://%s/", absolutePathTo("client")));
    }

    @Override
    public void configure(JtwigViewResolver viewResolver) {
        EnvironmentConfiguration configuration = EnvironmentConfigurationBuilder
                .configuration()
                    .extensions()
                    .add(new HotReloadingExtension(TimeUnit.SECONDS, 1))
                    .and()
                .build();
        viewResolver.setRenderer(new JtwigRenderer(configuration));
        viewResolver.setPrefix(String.format("file:%s/", absolutePathTo("templates/")));
        viewResolver.setSuffix(".twig.html");
    }

    private String absolutePathTo(String path) {
        return new File("src/main/resources/" + path).getAbsolutePath();
    }
}
