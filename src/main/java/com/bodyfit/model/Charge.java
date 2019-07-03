package com.bodyfit.model;

public class Charge {
  private Integer id;
  private String due_date;
  private Integer id_bodybuilder;
  private Double value;
  private Boolean paid;
  private String name;

  public Charge(Integer id, String due_date, Integer id_bodybuilder, Double value, Boolean paid, String name) {
    this.id = id;
    this.due_date = due_date;
    this.id_bodybuilder = id_bodybuilder;
    this.value = value;
    this.paid = paid;
    this.name = name;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDueDate() {
    return due_date;
  }

  public void setDueDate(String due_date) {
    this.due_date = due_date;
  }

  public Integer getIdBodybuilder() {
    return id_bodybuilder;
  }

  public void setIdBodybuilder(Integer id_bodybuilder) {
    this.id_bodybuilder = id_bodybuilder;
  }

  public Boolean getPaid() {
    return paid;
  }

  public void setPaid(Boolean paid) {
    this.paid = paid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
