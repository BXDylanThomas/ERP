package com.dylan.model;

import java.io.Serializable;

/**
 * 简历
 */
public class Resume  implements Serializable {

    private Integer id;
    private String name;  //姓名
    private String birth;  //出生年月
    private String sex;  //性别
    private Integer phone;  //联系电话
    private String address;  //联系地址
    private String email;  //邮箱
    private String education;  //最高学历
    private String major;   //专业
    private String exp;  //工作经验
    private Integer accId;  //账号id

    private Salary salary;

    public Resume() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", major='" + major + '\'' +
                ", experien='" + exp + '\'' +
                ", accId=" + accId +
                ", salary=" + salary +
                '}';
    }
}
