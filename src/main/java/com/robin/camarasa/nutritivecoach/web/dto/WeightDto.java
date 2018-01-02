package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.Weight;

public class WeightDto {
    private Long id;
    private Long id_user;
    private Float value;

    public WeightDto(Weight weight) {
        this.id_user = weight.getUser().getId();
        this.value = weight.getValue();
        this.id = weight.getId();
    }

    public Float getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public Long getId_user() {
        return id_user;
    }
}
