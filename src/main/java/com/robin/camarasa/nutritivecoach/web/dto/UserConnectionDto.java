package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.User;


public class UserConnectionDto {

    private final Long id;

    public UserConnectionDto(User user) {
        this.id = user.getId();
    }

    public UserConnectionDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}