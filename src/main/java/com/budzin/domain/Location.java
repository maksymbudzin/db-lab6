package com.budzin.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Country")
    private String Country;

    @Column(name = "City")
    private String City;

    public Location(Integer id, String country, String city) {
        this.id = id;
        Country = country;
        City = city;
    }

    public Location(String country, String city) {
         this(null, country, city);
    }

    public Location() {
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

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
