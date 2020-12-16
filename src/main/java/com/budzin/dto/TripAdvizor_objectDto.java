package com.budzin.dto;

public class TripAdvizor_objectDto {

    private Integer id;
    private String objec_name;
    private String number_of_star;
    private String free_room;
    private String busy_room;
    private String all_inclusive;
    private String ultra_all_inclusive;

    public TripAdvizor_objectDto(Integer id, String objec_name, String number_of_star, String free_room, String busy_room, String all_inclusive, String ultra_all_inclusive) {
        this.id = id;
        this.objec_name = objec_name;
        this.number_of_star = number_of_star;
        this.free_room = free_room;
        this.busy_room = busy_room;
        this.all_inclusive = all_inclusive;
        this.ultra_all_inclusive = ultra_all_inclusive;
    }

    public TripAdvizor_objectDto(String objec_name, String number_of_star, String free_room, String busy_room, String all_inclusive, String ultra_all_inclusive) {
        this.objec_name = objec_name;
        this.number_of_star = number_of_star;
        this.free_room = free_room;
        this.busy_room = busy_room;
        this.all_inclusive = all_inclusive;
        this.ultra_all_inclusive = ultra_all_inclusive;
    }

    public TripAdvizor_objectDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjec_name() {
        return objec_name;
    }

    public void setObjec_name(String objec_name) {
        this.objec_name = objec_name;
    }

    public String getNumber_of_star() {
        return number_of_star;
    }

    public void setNumber_of_star(String number_of_star) {
        this.number_of_star = number_of_star;
    }

    public String getFree_room() {
        return free_room;
    }

    public void setFree_room(String free_room) {
        this.free_room = free_room;
    }

    public String getBusy_room() {
        return busy_room;
    }

    public void setBusy_room(String busy_room) {
        this.busy_room = busy_room;
    }

    public String getAll_inclusive() {
        return all_inclusive;
    }

    public void setAll_inclusive(String all_inclusive) {
        this.all_inclusive = all_inclusive;
    }

    public String getUltra_all_inclusive() {
        return ultra_all_inclusive;
    }

    public void setUltra_all_inclusive(String ultra_all_inclusive) {
        this.ultra_all_inclusive = ultra_all_inclusive;
    }
}
