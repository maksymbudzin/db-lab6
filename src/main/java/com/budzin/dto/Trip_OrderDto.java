package com.budzin.dto;

public class Trip_OrderDto {

    private Integer id;
    private String price_in_dollars;
    private String date;
    private String Customer_id;

    public Trip_OrderDto(Integer id, String price_in_dollars, String date, String customer_id) {
        this.id = id;
        this.price_in_dollars = price_in_dollars;
        this.date = date;
        Customer_id = customer_id;
    }

    public Trip_OrderDto(String price_in_dollars, String date, String customer_id) {
        this.price_in_dollars = price_in_dollars;
        this.date = date;
        Customer_id = customer_id;
    }

    public Trip_OrderDto() {
    }

    public Trip_OrderDto(Integer id, String objec_name, String number_of_star, String free_room, String busy_room, String all_inclusive, String ultra_all_inclusive) {
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
}
