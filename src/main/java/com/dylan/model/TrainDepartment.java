package com.dylan.model;

import java.io.Serializable;

public class TrainDepartment implements Serializable {


    private Integer id;
    private Integer depId;  //部门id
    private Integer tId;  //培训表id
    private Integer state;

    private Train train;
    private Department department;

    public TrainDepartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "TrainDepartment{" +
                "id=" + id +
                ", depId=" + depId +
                ", tId=" + tId +
                ", state=" + state +
                ", train=" + train +
                ", department=" + department +
                '}';
    }
}
