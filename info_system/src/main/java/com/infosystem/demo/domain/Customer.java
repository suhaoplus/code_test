package com.infosystem.demo.domain;

public class Customer {
    private int customer_id;
    private String customer_name;
    private String sex;
    private String birthday;
    private String id;
    private String tel;
    private int remarks;

    public Customer(int customer_id, String customer_name, String sex, String birthday, String id, String tel, int remarks) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.sex = sex;
        this.birthday = birthday;
        this.id = id;
        this.tel = tel;
        this.remarks = remarks;
    }

    public Customer(String customer_name, String sex, String birthday, String id, String tel) {
        this.customer_name = customer_name;
        this.sex = sex;
        this.birthday = birthday;
        this.id = id;
        this.tel = tel;
    }

    public Customer() {
        super();
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRemarks() {
        return remarks;
    }

    public void setRemarks(int remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", id='" + id + '\'' +
                ", tel='" + tel + '\'' +
                ", remarks=" + remarks +
                '}';
    }
}
