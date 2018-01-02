package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categorie;

    @Column(nullable = false)
    private String intitule;

    @Column(nullable = false)
    private Float energie;

    @Column(nullable = false)
    private Float eau;

    @Column(nullable = false)
    private Float proteines;

    @Column(nullable = false)
    private Float proteines_brutes;

    @Column(nullable = false)
    private Float glucides;

    @Column(nullable = false)
    private Float lipides;

    @Column(nullable = false)
    private Float sucres;

    @Column(nullable = false)
    private Float amidon;

    @Column(nullable = false)
    private Float fibres;

    @Column(nullable = false)
    private Float alcool;

    @Column(nullable = false)
    private Float acides_organiques;

    @Column(nullable = false)
    private Float satures;

    @Column(nullable = false)
    private Float monoinsatures;

    @Column(nullable = false)
    private Float polyinsatures;

    @Column(nullable = false)
    private Float cholesterol;

    @Column(nullable = false)
    private Float sel;

    @Column(nullable = false)
    private Float calcium;

    @SuppressWarnings("unused")
    public Food() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setAcides_organiques(Float acides_organiques) {
        this.acides_organiques = acides_organiques;
    }

    public void setAlcool(Float alcool) {
        this.alcool = alcool;
    }

    public void setAmidon(Float amidon) {
        this.amidon = amidon;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setCholesterol(Float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public void setCalcium(Float calcium) {
        this.calcium = calcium;
    }

    public void setEau(Float eau) {
        this.eau = eau;
    }

    public void setEnergie(Float energie) {
        this.energie = energie;
    }

    public void setFibres(Float fibres) {
        this.fibres = fibres;
    }

    public void setGlucides(Float glucides) {
        this.glucides = glucides;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setLipides(Float lipides) {
        this.lipides = lipides;
    }

    public void setProteines(Float proteines) {
        this.proteines = proteines;
    }

    public void setMonoinsatures(Float monoinsatures) {
        this.monoinsatures = monoinsatures;
    }

    public void setPolyinsatures(Float polyinsatures) {
        this.polyinsatures = polyinsatures;
    }

    public void setProteines_brutes(Float proteines_brutes) {
        this.proteines_brutes = proteines_brutes;
    }

    public void setSatures(Float satures) {
        this.satures = satures;
    }

    public void setSel(Float sel) {
        this.sel = sel;
    }

    public void setSucres(Float sucres) {
        this.sucres = sucres;
    }


}
