package com.dylan.model;

import java.io.Serializable;

/**
 * 惩罚记录表
 */
public class PrizeRecord implements Serializable {

    private Integer id;
    private Integer empId;  //员工id
    private String reason; //奖惩原因
    private Double money;  //奖惩金额   小于0 就是罚   大于0  是奖
    private String time;  // 奖惩时间
    private Integer calId;  //薪资结算id

    public PrizeRecord() {
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    @Override
    public String toString() {
        return "PrizeRecordDao{" +
                "id=" + id +
                ", empId=" + empId +
                ", reason='" + reason + '\'' +
                ", money=" + money +
                ", time='" + time + '\'' +
                ", calId=" + calId +
                '}';
    }
}
