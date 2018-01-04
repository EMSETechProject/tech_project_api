package com.robin.camarasa.nutritivecoach.problem_solving.csp.db;

import com.robin.camarasa.nutritivecoach.model.Objectif;
import com.robin.camarasa.nutritivecoach.model.User;

public class UserCSPDto {
    private Long id;
    private Float imc;
    private Float calories;

    public UserCSPDto(User user, Objectif objectif) {
        id = user.getId();
        imc = ((user.getPhysicalData().getWeight() - objectif.getValue())/2f + objectif.getValue()) / (user.getPhysicalData().getSize()*user.getPhysicalData().getSize());
        calories = computeCal(imc);
    }

    public Float computeCal(Float imc) {
        return (imc - 21.25f) * (350f/2.75f) + 1100f;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }
}
