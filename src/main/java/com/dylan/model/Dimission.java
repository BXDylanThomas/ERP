package com.dylan.model;

import java.io.Serializable;

/**
 * 离职记录表
 */
public class Dimission implements Serializable {

    private Integer id;
    private Integer empId;
    private Integer depId;
    private Integer posId;
    private String entryTime;
    private String outTime;
    private String description;

    public Dimission() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dimission{" +
                "id=" + id +
                ", empId=" + empId +
                ", depId=" + depId +
                ", posId=" + posId +
                ", entryTime='" + entryTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

