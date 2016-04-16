package org.jtwig.boot.controller;

import org.jtwig.boot.config.JtwigConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Import(JtwigConfiguration.class)
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/{name}")
    public String indexAction (ModelMap model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
