package com.bodyfit.dto;

import com.bodyfit.model.Card;

import java.util.ArrayList;



public class CircuitDTO {
    private Integer id_instructor;
    private Integer id_bodybuilder;
    private Integer id_intensity;
    private ArrayList<Card> cards;


    public Integer getIdInstructor() {
        return id_instructor;
    }

    public void setIdInstructor(Integer id_instructor) {
        this.id_instructor = id_instructor;
    }

    public Integer getIdBodybuilder() {
        return id_bodybuilder;
    }

    public CircuitDTO(Integer id_instructor, Integer id_bodybuilder, Integer id_intensity, ArrayList<Card> cards) {
        this.id_instructor = id_instructor;
        this.id_bodybuilder = id_bodybuilder;
        this.id_intensity = id_intensity;
        this.cards = cards;
    }

    public void setIdBodybuilder(Integer id_bodybuilder) {
        this.id_bodybuilder = id_bodybuilder;
    }

    public Integer getIdIntensity() {
        return id_intensity;
    }

    public void setIdIntensity(Integer id_intensity) {
        this.id_intensity = id_intensity;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
