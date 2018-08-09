package com.infosystem.demo.domain;

public class Style {
    private Integer style_id;
    private String style_name;
    private Integer cost;
    private Integer total;
    private Integer rest;
    private String remarks;

    public Style(Integer style_id, String style_name, Integer cost, Integer total, Integer rest, String remarks) {
        this.style_id = style_id;
        this.style_name = style_name;
        this.cost = cost;
        this.total = total;
        this.rest = rest;
        this.remarks = remarks;
    }

    public Style() {
        super();
    }

    public Integer getStyle_id() {
        return style_id;
    }

    public void setStyle_id(Integer style_id) {
        this.style_id = style_id;
    }

    public String getStyle_name() {
        return style_name;
    }

    public void setStyle_name(String style_name) {
        this.style_name = style_name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "Style{" +
                "style_id=" + style_id +
                ", style_name='" + style_name + '\'' +
                ", cost=" + cost +
                ", total=" + total +
                ", rest=" + rest +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
