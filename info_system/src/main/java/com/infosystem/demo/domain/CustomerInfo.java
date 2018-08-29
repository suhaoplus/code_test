package com.infosystem.demo.domain;

public class CustomerInfo {
    private String customer_name;
    private String tel;
    private String in_time;
    private int deposit;
    private String staff_name;


    public CustomerInfo(String customer_name, String tel, String in_time, int deposit, String staff_name) {
        this.customer_name = customer_name;
        this.tel = tel;
        this.in_time = in_time;
        this.deposit = deposit;
        this.staff_name = staff_name;
    }

    public CustomerInfo() {
        super();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customer_name='" + customer_name + '\'' +
                ", tel='" + tel + '\'' +
                ", in_time='" + in_time + '\'' +
                ", deposit=" + deposit +
                ", staff_name='" + staff_name + '\'' +
                '}';
    }
}
