package com.budzin.domain;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "feedback_text")
    private String feedback_text;

    @Column(name = "time")
    private String time;

    @Column(name = "Customer_id")
    private String Customer_id;

    @Column(name = "Customer_Trip_Order_id")
    private String Customer_Trip_Order_id;

    public Feedback(Integer id, String feedback_text, String time, String customer_id, String customer_Trip_Order_id) {
        this.id = id;
        this.feedback_text = feedback_text;
        this.time = time;
        Customer_id = customer_id;
        Customer_Trip_Order_id = customer_Trip_Order_id;
    }

    public Feedback(String feedback_text, String time, String customer_id, String customer_Trip_Order_id) {
         this(null, feedback_text, time, customer_id, customer_Trip_Order_id);
    }

    public Feedback() {
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

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedback_text='" + feedback_text + '\'' +
                ", time='" + time + '\'' +
                ", Customer_id='" + Customer_id + '\'' +
                ", Customer_Trip_Order_id='" + Customer_Trip_Order_id + '\'' +
                '}';
    }
}
