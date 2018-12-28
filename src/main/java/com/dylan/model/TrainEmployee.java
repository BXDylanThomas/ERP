package com.dylan.model;

import java.io.Serializable;

/**
 * 培训员工表
 */
public class TrainEmployee implements Serializable {

    private Integer id;
    private Integer empId;  //职员id
    private Integer tId;  //培训表id
    private Integer state;  //状态  1 已读   0  未读

    private Train train;
    private Employee employee;

    public TrainEmployee() {
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

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TrainEmployee{" +
                "id=" + id +
                ", empId=" + empId +
                ", tId=" + tId +
                ", state=" + state +
                ", train=" + train +
                '}';
    }
}
