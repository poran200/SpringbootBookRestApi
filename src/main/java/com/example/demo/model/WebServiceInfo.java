package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class WebServiceInfo extends RepresentationModel<WebServiceInfo> {
    private String webserviceName;
    private String version;
    private String name;
    private long id;
    private String swaggerLink;
}
