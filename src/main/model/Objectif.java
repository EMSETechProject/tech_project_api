package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Objectif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private Float value;


    @SuppressWarnings("unused")
    public Objectif() {
    }

    public Objectif(Long id, User user, Float value) {
        this.id = id;
        this.user = user;
        this.value = value;
    }

    public Objectif(User user, Float value) {
        this.user = user;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}