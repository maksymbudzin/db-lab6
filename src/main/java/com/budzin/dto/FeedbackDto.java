package com.budzin.dto;


public class FeedbackDto {

    private Integer id;
    private String feedback_text;
    private String time;
    private String Customer_id;
    private String Customer_Trip_Order_id;

    public FeedbackDto(Integer id, String feedback_text, String time, String customer_id, String customer_Trip_Order_id) {
        this.id = id;
        this.feedback_text = feedback_text;
        this.time = time;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public FeedbackDto(String feedback_text, String time, String customer_id, String customer_Trip_Order_id) {
        this.feedback_text = feedback_text;
        this.time = time;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public FeedbackDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedback_text() {
        return feedback_text;
    }

    public void setFeedback_text(String feedback_text) {
        this.feedback_text = feedback_text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
