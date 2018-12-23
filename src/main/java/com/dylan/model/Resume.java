package com.dylan.model;

import java.io.Serializable;

/**
 * 简历
 */
public class Resume implements Serializable {

    private Integer id;  //自增id
    private Integer visid; //游客id
    private String name; //姓名
    private String sex;  //性别
    private Integer age;  //年龄
    private String birth; //出生年月
    private String address; //联系地址
    private Integer phone;  //联系电话
    private String email;  //联系邮箱
    private String education; //学历
    private String school;   //毕业学校
    private Double salary;  //期望薪资
    private String experience;  //工作经验
    private String selfEvaluate;  //自我评价

    public Resume() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisid() {
        return visid;
    }

    public void setVisid(Integer visid) {
        this.visid = visid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSelfEvaluate() {
        return selfEvaluate;
    }

    public void setSelfEvaluate(String selfEvaluate) {
        this.selfEvaluate = selfEvaluate;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", visid=" + visid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", salary=" + salary +
                ", experience='" + experience + '\'' +
                ", selfEvaluate='" + selfEvaluate + '\'' +
                '}';
    }
}
