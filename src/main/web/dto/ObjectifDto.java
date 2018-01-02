package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Objectif;

public class ObjectifDto {

    private Long id;
    private Long id_user;
    private Float value;

    public ObjectifDto(Objectif objectif) {
        this.id = objectif.getId();
        this.id_user = objectif.getUser().getId();
        this.value = objectif.getValue();
    }

    public Long getId() {
        return id;
    }

    public Long getId_user() {
        return id_user;
    }

    public Float getValue() {
        return value;
    }
}
