package com.bodyfit.model;

public class Card {
    private String name;
    private Integer series;
    private Integer repetition;
    private Double weight;

    public Card(String name, Integer series, Integer repetition, Double weight) {
        this.name = name;
        this.series = series;
        this.repetition = repetition;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
