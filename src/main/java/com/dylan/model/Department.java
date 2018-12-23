package com.dylan.model;

import javafx.geometry.Pos;

import java.io.Serializable;
import java.util.List;

/**
 * 部门
 */
public class Department implements Serializable {

    private Integer id;  //自增id
    private String name;  //部门名字
    private String description; //部门描述
    private String createTime;  //创建时间
    private Integer state;  //状态   -1  已经删除   1   还在

    private List<Position> positions;
    private List<Employee> employees;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state=" + state +
                '}';
    }
}
