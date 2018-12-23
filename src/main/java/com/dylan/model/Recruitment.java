package com.dylan.model;

import java.io.Serializable;

/**
 * 招聘
 */
public class Recruitment implements Serializable {

    private Integer id;  //自增id
    private Integer depid;  //招聘部门id
    private Integer posid;   //招聘职位id
    private String description;  //职位要求描述
    private String company;   //公司介绍
    private String comAddress;  //公司地址
    private String experience;  //要求经验
    private String education;   //要求学历

    public Recruitment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", depid=" + depid +
                ", posid=" + posid +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
