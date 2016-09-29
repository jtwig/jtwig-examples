package org.jtwig.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("")
    public String indexAction () {
        return "index";
    }
}
