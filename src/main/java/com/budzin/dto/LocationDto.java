package com.budzin.dto;

public class LocationDto {

    private Integer id;
    private String Country;
    private String City;

    public LocationDto(Integer id, String country, String city) {
        this.id = id;
        Country = country;
        City = city;
    }

    public LocationDto(String country, String city) {
        Country = country;
        City = city;
    }

    public LocationDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
