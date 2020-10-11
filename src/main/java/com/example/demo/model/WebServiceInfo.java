package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@AllArgsConstructor

public class WebServiceInfo  {
    public WebServiceInfo(String webserviceName, String version, String name, long id) {
        this.webserviceName = webserviceName;
        this.version = version;
        this.name = name;
        this.id = id;
    }

    private String webserviceName;
    private String version;
    private String name;
    private long id;
    private String swagger;

}
