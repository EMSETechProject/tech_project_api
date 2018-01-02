package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;


public class PhysicalDataDto {

    private final Long id;
    private final Float weight;
    private final Float size;
    private final Integer age;

    public PhysicalDataDto(PhysicalData physicalData) {
        this.id = physicalData.getId();
        this.weight = physicalData.getWeight();
        this.size = physicalData.getSize();
        this.age = physicalData.getAge();
    }

    public Float getSize() {
        return size;
    }

    public Float getWeight() {
        return weight;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

}