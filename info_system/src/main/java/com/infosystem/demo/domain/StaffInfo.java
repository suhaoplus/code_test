package com.infosystem.demo.domain;

public class StaffInfo {
    private int staff_id;
    private String staff_name;
    private String sex;
    private String birthday;
    private String years;
    private String tel;
    private int remarks;

    public StaffInfo(int staff_id, String staff_name, String sex, String birthday, String years, String tel,int remarks) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.sex = sex;
        this.birthday = birthday;
        this.years = years;
        this.tel = tel;
        this.remarks = remarks;
    }

    public StaffInfo(int staff_id, String staff_name, String sex, String birthday, String years, String tel) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.sex = sex;
        this.birthday = birthday;
        this.years = years;
        this.tel = tel;
    }

    public StaffInfo(String staff_name, String sex, String birthday, String years, String tel) {
        this.staff_name = staff_name;
        this.sex = sex;
        this.birthday = birthday;
        this.years = years;
        this.tel = tel;
    }

    public int getRemarks() {
        return remarks;
    }

    public void setRemarks(int remarks) {
        this.remarks = remarks;
    }

    public StaffInfo() {
        super();
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
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

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", years=" + years +
                ", tel='" + tel + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
