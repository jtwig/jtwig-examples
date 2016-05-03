package org.jtwig.example.json;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.json.JsonExtension;

public class SimpleJsonApp {
    public static void main(String[] args) {
        EnvironmentConfiguration configuration = EnvironmentConfigurationBuilder.configuration()
                .extensions().add(JsonExtension.defaultJsonExtension()).and()
                .build();
        JtwigTemplate jtwigTemplate = JtwigTemplate.inlineTemplate("{{ json_encode(variable) }}", configuration);
        JtwigModel jtwigModel = JtwigModel.newModel().with("variable", new Model(
                "My Name", 30, "Committer"
        ));

        System.out.println(jtwigTemplate.render(jtwigModel));
    }

    private static class Model {
        private final String name;
        private final int age;
        private final String group;

        public Model(String name, int age, String group) {
            this.name = name;
            this.age = age;
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGroup() {
            return group;
        }
    }
}
