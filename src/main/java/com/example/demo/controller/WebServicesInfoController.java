package com.example.demo.controller;

import com.example.demo.model.WebServiceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class WebServicesInfoController {
      @GetMapping("/")
      public WebServiceInfo getWebServicesInfo() {

          WebServiceInfo webServiceInfo= new WebServiceInfo("Book Api","api/v1",
                  "MD Najmul Hasan",2017100000028L);

         webServiceInfo.setSwagger(new RedirectView("swagger"));
         return webServiceInfo;

      }
}
