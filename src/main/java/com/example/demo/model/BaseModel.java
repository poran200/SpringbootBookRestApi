package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModel {

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private Boolean isActive;

    @PrePersist
    public void setPreInsertData(){
        this.createdAt = new Date();
        this.isActive = true;
    }
    @PreUpdate
    public void setPostUpdateData(){
        this.updatedAt = new Date();
    }

}
