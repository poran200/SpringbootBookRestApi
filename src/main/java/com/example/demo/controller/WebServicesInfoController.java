package com.example.demo.controller;

import com.example.demo.model.WebServiceInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class WebServicesInfoController {
      @GetMapping
      public ResponseEntity<Object> getWebServicesInfo(){
          WebServiceInfo webServiceInfo = new WebServiceInfo();
          webServiceInfo.setWebserviceName("Book Api");
          webServiceInfo.setVersion("api/v1");
          webServiceInfo.setName("MD Najmul Hasan");
          webServiceInfo.setId(2017100000028L);
          webServiceInfo.add(linkTo(methodOn(SwaggerInitialController.class)).withRel("swagger"));
          return ResponseEntity.ok(webServiceInfo);
      }
}
