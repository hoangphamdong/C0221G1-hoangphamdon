package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ren_type")
public class RenType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ren_type_id")
    private Integer renTypeId;
    private String renTypeName;
    private Double renTypeCost;
    @OneToMany(mappedBy = "renType")
    private List<Service>services;

    public RenType() {
    }

    public RenType(Integer renTypeId, String renTypeName, Double renTypeCost, List<Service> services) {
        this.renTypeId = renTypeId;
        this.renTypeName = renTypeName;
        this.renTypeCost = renTypeCost;
        this.services = services;
    }

    public Integer getRenTypeId() {
        return renTypeId;
    }

    public void setRenTypeId(Integer renTypeId) {
        this.renTypeId = renTypeId;
    }

    public String getRenTypeName() {
        return renTypeName;
    }

    public void setRenTypeName(String renTypeName) {
        this.renTypeName = renTypeName;
    }

    public Double getRenTypeCost() {
        return renTypeCost;
    }

    public void setRenTypeCost(Double renTypeCost) {
        this.renTypeCost = renTypeCost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
