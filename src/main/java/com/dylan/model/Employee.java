package com.dylan.model;

import java.io.Serializable;

/**
 * 员工
 */
public class Employee implements Serializable {

    private Integer id;
    private Integer accId;  //登录账号的id
    private Integer resId; //简历id
    private Integer posId;  //职位id
    private String entryTime;  //入职时间
    private Double salary;   //基本工资
    private Double performance;  //绩效奖金
    private Integer empState;   //状态    leave 离职  1     regular 在职  2      watch 试用期 3

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", accId=" + accId +
                ", resId=" + resId +
                ", posId=" + posId +
                ", entryTime='" + entryTime + '\'' +
                ", salary=" + salary +
                ", performance=" + performance +
                ", empState='" + empState + '\'' +
                '}';
    }
}
