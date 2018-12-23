package com.dylan.model;

import java.io.Serializable;
import java.util.List;

/**
 * 职位
 */
public class Position implements Serializable {

    private Integer id; //自增id
    private Integer depid;  //部门id
    private String name;  //职位名称
    private String description;  //职位描述
    private String createTime;  //创建时间
    private Double salary;   //职位基本工资
    private Integer state;  //状态   -1  已经删除   1还在

    private Department department;
    private List<Employee> employees;

    public Position() {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", depid=" + depid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime='" + createTime + '\'' +
                ", salary=" + salary +
                ", state=" + state +
                '}';
    }
}
