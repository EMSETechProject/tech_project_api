package com.robin.camarasa.nutritvecoach.model;

import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private PhysicalData physicalData;

    @SuppressWarnings("unused")
    public User() {
    }

    public User(String pseudo, String password, PhysicalData physicalData) {
        this.password = password;
        this.pseudo = pseudo;
        this.physicalData = physicalData;
    }

    public User(Long id, String pseudo, String password, PhysicalData physicalData) {
        this.id = id;
        this.password = password;
        this.pseudo = pseudo;
        this.physicalData = physicalData;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public PhysicalData getPhysicalData() {
        return physicalData;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhysicalData(PhysicalData physicalData) {
        this.physicalData = physicalData;
    }
}
