package com.budzin.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_of_star")
    private String number_of_star;

    @Column(name = "date")
    private String date;

    @Column(name = "Customer_id")
    private String Customer_id;

    @Column(name = "Customer_Trip_Order_id")
    private String Customer_Trip_Order_id;

    public Rating(Integer id, String number_of_star, String date, String customer_id, String customer_Trip_Order_id) {
        this.id = id;
        this.number_of_star = number_of_star;
        this.date = date;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public Rating(String number_of_star, String date, String customer_id, String customer_Trip_Order_id) {
        this(null, number_of_star, date, customer_id, customer_Trip_Order_id);
    }

    public Rating() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber_of_star() {
        return number_of_star;
    }

    public void setNumber_of_star(String number_of_star) {
        this.number_of_star = number_of_star;
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

    public String getCustomer_Trip_Order_id() {
        return Customer_Trip_Order_id;
    }

    public void setCustomer_Trip_Order_id(String customer_Trip_Order_id) {
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", number_of_star='" + number_of_star + '\'' +
                ", date='" + date + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                ", Customer_Trip_Order_id='" + Customer_Trip_Order_id + '\'' +
                '}';
    }
}
