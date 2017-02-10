package org.jtwig.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/{name}"})
    public String indexAction (ModelMap model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        return "index";
    }
}
