package com.dylan.model;

import java.io.Serializable;

/**
 * 部门
 */
public class Department implements Serializable {

    private Integer id;
    private String name;
    private String createTime;

    public Department() {
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
