package com.example.demo.entity;


import org.hibernate.validator.constraints.NotBlank;

public class User {

  private int id;

  @NotBlank(message = "{require_check}")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
