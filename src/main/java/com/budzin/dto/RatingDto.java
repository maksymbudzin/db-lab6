package com.budzin.dto;

public class RatingDto {

    private Integer id;
    private String number_of_star;
    private String date;
    private String Customer_id;
    private String Customer_Trip_Order_id;

    public RatingDto(Integer id, String number_of_star, String date, String customer_id, String customer_Trip_Order_id) {
        this.id = id;
        this.number_of_star = number_of_star;
        this.date = date;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public RatingDto(String number_of_star, String date, String customer_id, String customer_Trip_Order_id) {
        this.number_of_star = number_of_star;
        this.date = date;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public RatingDto() {
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
}
