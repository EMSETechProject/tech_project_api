package com.robin.camarasa.nutritivecoach.Neural_network;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class NNNeuron {
    @Id
    private Long id;

    @Column(nullable = false)
    private Float value;

    public NNNeuron() {
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
