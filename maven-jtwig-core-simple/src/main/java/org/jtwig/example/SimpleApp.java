package org.jtwig.example;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class SimpleApp {
    public static void main(String[] args) {
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/example.twig");
        JtwigModel model = JtwigModel.newModel().with("var", "World");

        template.render(model, System.out);
    }
}