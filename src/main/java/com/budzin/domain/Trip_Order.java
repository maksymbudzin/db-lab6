package com.budzin.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Trip_Order")

public class Trip_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price_in_dollars")
    private String price_in_dollars;

    @Column(name = "date")
    private String date;

    @Column(name = "Customer_id")
    private String Customer_id;

    public Trip_Order(Integer id, String price_in_dollars, String date, String customer_id) {
        this.id = id;
        this.price_in_dollars = price_in_dollars;
        this.date = date;
        Customer_id = customer_id;
    }

    public Trip_Order(String price_in_dollars, String date, String customer_id) {
         this(null, price_in_dollars, date, customer_id);
    }

    public Trip_Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice_in_dollars() {
        return price_in_dollars;
    }

    public void setPrice_in_dollars(String price_in_dollars) {
        this.price_in_dollars = price_in_dollars;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Trip_Order{" +
                "id=" + id +
                ", price_in_dollars='" + price_in_dollars + '\'' +
                ", date='" + date + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                '}';
    }
}