package com.dylan.model;

import java.io.Serializable;

/**
 * 薪资结算
 */
public class SalaryCal implements Serializable {

    private Integer id;
    private Integer empId;  //员工id
    private String time;   //薪资结算时间

    private Employee employee;

    public SalaryCal() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "SalaryCal{" +
                "id=" + id +
                ", empId=" + empId +
                ", time='" + time + '\'' +
                ", employee=" + employee +
                '}';
    }
}
