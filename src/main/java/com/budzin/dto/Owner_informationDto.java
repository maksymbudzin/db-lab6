package com.budzin.dto;

public class Owner_informationDto {

    private Integer id;
    private String Name;
    private String Surname;
    private String country;

    public Owner_informationDto(Integer id, String name, String surname, String country) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.country = country;
    }

    public Owner_informationDto(String name, String surname, String country) {
        Name = name;
        Surname = surname;
        this.country = country;
    }

    public Owner_informationDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
