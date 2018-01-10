package com.robin.camarasa.nutritivecoach.IA.Neural_network;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class NNWeight {
    @Id
    private Long id;

    @Column(nullable = false)
    private Float value;

    public NNWeight() {
    }

    public NNWeight(Long id, Float value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
