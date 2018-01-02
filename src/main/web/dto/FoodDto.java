package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;


public class FoodDto {

    private final Long id;
    private final String categorie;
    private final String intitule;
    private final Float energie;
    private final Float eau;
    private final Float proteines;
    private final Float proteines_brutes;
    private final Float glucides;
    private final Float lipides;
    private final Float sucres;
    private final Float amidon;
    private final Float fibres;
    private final Float alcool;
    private final Float acides_organiques;
    private final Float satures;
    private final Float monoinsatures;
    private final Float polyinsatures;
    private final Float cholesterol;
    private final Float sel;
    private final Float calcium;

    public FoodDto(Food food) {
        this.id = food.getId();
        //,sel,calcium)
        this.categorie = food.getCategorie();
        this.intitule = food.getIntitule();
        this.energie = food.getEnergie();
        this.eau = food.getEau();
        this.proteines = food.getProteines();
        this.proteines_brutes = food.getProteines_brutes();
        this.glucides = food.getGlucides();
        this.lipides = food.getLipides();
        this.sucres = food.getSucres();
        this.amidon = food.getAmidon();
        this.fibres = food.getFibres();
        this.alcool = food.getAlcool();
        this.acides_organiques = food.getAcides_organiques();
        this.satures = food.getSatures();
        this.monoinsatures = food.getMonoinsatures();
        this.polyinsatures = food.getPolyinsatures();
        this.cholesterol = food.getCholesterol();
        this.sel = food.getSel();
        this.calcium = food.getCalcium();
    }

    public Long getId() {
        return id;
    }

    public Float getAcides_organiques() {
        return acides_organiques;
    }

    public Float getAmidon() {
        return amidon;
    }

    public Float getAlcool() {
        return alcool;
    }

    public Float getEau() {
        return eau;
    }

    public Float getEnergie() {
        return energie;
    }

    public Float getFibres() {
        return fibres;
    }

    public Float getGlucides() {
        return glucides;
    }

    public Float getLipides() {
        return lipides;
    }

    public Float getCholesterol() {
        return cholesterol;
    }

    public Float getProteines() {
        return proteines;
    }

    public Float getProteines_brutes() {
        return proteines_brutes;
    }

    public Float getSucres() {
        return sucres;
    }

    public Float getSatures() {
        return satures;
    }

    public Float getCalcium() {
        return calcium;
    }

    public Float getSel() {
        return sel;
    }

    public Float getMonoinsatures() {
        return monoinsatures;
    }

    public Float getPolyinsatures() {
        return polyinsatures;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getIntitule() {
        return intitule;
    }
}