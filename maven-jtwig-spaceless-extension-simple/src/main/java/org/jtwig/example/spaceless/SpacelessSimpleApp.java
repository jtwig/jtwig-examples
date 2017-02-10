package org.jtwig.example.spaceless;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spaceless.SpacelessExtension;

public class SpacelessSimpleApp {
    public static void main(String[] args) {
        System.out.println(JtwigTemplate
                .classpathTemplate("template.twig", EnvironmentConfigurationBuilder.configuration()
                        .extensions().add(SpacelessExtension.defaultSpacelessExtension()).and()
                        .build())
                .render(JtwigModel.newModel()));
    }
}
