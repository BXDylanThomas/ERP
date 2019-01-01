package com.dylan.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 考勤记录表
 */
public class CheckRecord implements Serializable,Comparable {

    private Integer id;
    private Integer empId;  //员工id
    private String workTime;  //上班时间
    private String offTime;  //下班时间
    private Integer workState;  //上班状态  1. 正常 2.迟到   4.旷工
    private Integer offState;  //下班状态  1.正常 3.早退  4.旷工
    private Integer overTime; //是否是加班


    public CheckRecord() {
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

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

    public Integer getOffState() {
        return offState;
    }

    public void setOffState(Integer offState) {
        this.offState = offState;
    }


    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    @Override
    public String toString() {
        return "CheckRecord{" +
                "id=" + id +
                ", empId=" + empId +
                ", workTime='" + workTime + '\'' +
                ", offTime='" + offTime + '\'' +
                ", workState=" + workState +
                ", offState=" + offState +
                ", overTime=" + overTime +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        CheckRecord checkRecord= (CheckRecord) o;
        String time1=this.workTime!=null?this.workTime:this.offTime;
        String time2=checkRecord.workTime!=null?checkRecord.workTime:checkRecord.offTime;
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(time1);
            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(time2);
            Calendar calendar1=Calendar.getInstance();
            calendar1.setTime(date1);
            Calendar calendar2=Calendar.getInstance();
            calendar2.setTime(date2);
            return calendar1.get(5)-calendar2.get(5);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

