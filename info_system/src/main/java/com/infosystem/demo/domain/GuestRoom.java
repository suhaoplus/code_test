package com.infosystem.demo.domain;

public class GuestRoom {
    private Integer guest_room_id;
    private Integer type_id;
    private String state;
    private String remarks;

    public GuestRoom() {
        super();
    }

    public GuestRoom(Integer guest_room_id, Integer type_id, String state, String remarks) {
        this.guest_room_id = guest_room_id;
        this.type_id = type_id;
        this.state = state;
        this.remarks = remarks;
    }

    public Integer getGuest_room_id() {
        return guest_room_id;
    }

    public void setGuest_room_id(Integer guest_room_id) {
        this.guest_room_id = guest_room_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "GuestRoom{" +
                "guest_room_id=" + guest_room_id +
                ", type_id=" + type_id +
                ", state='" + state + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
