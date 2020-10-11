package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
public class WebServiceInfo extends RepresentationModel<WebServiceInfo> {
    private String webserviceName;
    private String version;
    private String name;
    private long id;

}
