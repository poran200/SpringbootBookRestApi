package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SwaggerInitialController {
    @GetMapping("/")
    public RedirectView getSwager(){
        return new RedirectView("swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/");
    }
}
