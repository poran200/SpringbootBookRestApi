package com.example.demo.controller;

import com.example.demo.model.WebServiceInfo;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/")
public class WebServicesInfoController {
      @GetMapping("/")
      public WebServiceInfo getWebServicesInfo() throws MalformedURLException {

          WebServiceInfo webServiceInfo= new WebServiceInfo("Book Api","api/v1",
                  "MD Najmul Hasan",2017100000028L);


         webServiceInfo.setSwagger(new UrlResource(UriComponentsBuilder.fromPath("/swagger").toUriString()));
         return webServiceInfo;

      }
}
