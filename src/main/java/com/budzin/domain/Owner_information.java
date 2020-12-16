package com.budzin.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Owner_information")
public class Owner_information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "country")
    private String country;

    public Owner_information(Integer id, String name, String surname, String country) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.country = country;
    }

    public Owner_information(String name, String surname, String country) {
         this(null, name, surname, country);
    }

    public Owner_information() {
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

    @Override
    public String toString() {
        return "Owner_information{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
