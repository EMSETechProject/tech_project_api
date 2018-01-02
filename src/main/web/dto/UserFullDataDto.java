package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.Objectif;
import com.robin.camarasa.nutritvecoach.model.User;


public class UserFullDataDto {

    private Long id_objectif;
    private Long id;
    private String pseudo;
    private String password;
    private Float value;

    public UserFullDataDto(User user, Objectif objectif) {
        this.id_objectif = objectif.getId();
        this.id = user.getId();
        this.pseudo = user.getPseudo();
        this.password = user.getPassword();
        this.value = objectif.getValue();
    }

    public Long getId_objectif() {
        return id_objectif;
    }

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public Float getValue() {
        return value;
    }
}