package com.dylan.model;

import java.io.Serializable;

/**
 * 员工离职
 */
public class EmployeeLeave implements Serializable {
    private Integer id;
    private Integer empId;
    private String reason;
    private String time;

    public EmployeeLeave() {
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

    @Override
    public String toString() {
        return "EmployeeLeave{" +
                "id=" + id +
                ", empId=" + empId +
                ", reason='" + reason + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
