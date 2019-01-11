package com.dylan.model;

import java.io.Serializable;

/**
 * 薪资复议表
 */
public class SalaryReview implements Serializable {

    private Integer id;
    private Integer empId;   //薪资结算表id
    private String reason;  //复议原因
    private String time;   //复议时间
    private Integer state;  //是否处理
    private Employee employee;

    public SalaryReview() {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "SalaryReview{" +
                "id=" + id +
                ", empId=" + empId +
                ", reason='" + reason + '\'' +
                ", time='" + time + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
