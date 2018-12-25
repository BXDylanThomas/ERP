package com.dylan.model;

import java.io.Serializable;

/**
 * 职务
 */
public class Position implements Serializable,Comparable {

    private Integer id;
    private String name;
    private String createTime;
    private Integer depId;  //部门id
    private Department department;

    public Position() {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", depId=" + depId +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Position P= (Position) o;
        return this.getDepId()-((Position) o).depId;
    }
}
