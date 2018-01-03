package com.robin.camarasa.nutritivecoach.Rating;

import org.kie.api.definition.type.ClassReactive;

@ClassReactive
public class Rate {

    private Float value;

    public Rate(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value : " + value;
    }
}
