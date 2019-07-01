package com.bodyfit.model;

public class Charge {
  private Integer id;
  private String due_date;
  private Integer id_bodybuilder;
  private Integer value;
  private Boolean paid;

  public Charge(Integer id, String due_date, Integer id_bodybuilder, Integer value, Boolean paid) {
    this.id = id;
    this.due_date = due_date;
    this.id_bodybuilder = id_bodybuilder;
    this.value = value;
    this.paid = paid;
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

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Boolean getPaid() {
    return paid;
  }

  public void setPaid(Boolean paid) {
    this.paid = paid;
  }
}
