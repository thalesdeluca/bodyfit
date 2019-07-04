package com.bodyfit.model;

public class Card {
    private String name;
    private Integer series;
    private Integer repetitions;
    private Double weight;

    public Card(String name, Integer series, Integer repetitions, Double weight) {
        this.name = name;
        this.series = series;
        this.repetitions = repetitions;
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

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
