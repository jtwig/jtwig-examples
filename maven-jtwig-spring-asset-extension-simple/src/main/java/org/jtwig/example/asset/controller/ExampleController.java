package org.jtwig.example.asset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExampleController {
    @RequestMapping("/")
    public String indexAction () {
        return "index";
    }
}
