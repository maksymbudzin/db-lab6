package com.budzin.dto;


public class CustomerDto {

    private Integer id;
    private String name;
    private String surname;

    public CustomerDto(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public CustomerDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
