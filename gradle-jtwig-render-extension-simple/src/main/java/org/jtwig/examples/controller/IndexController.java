package org.jtwig.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String indexAction () {
        return "index";
    }

    @RequestMapping("/hello")
    public String helloAction () {
        return "hello";
    }
}
