package com.dylan.model;

import java.io.Serializable;

/**
 * 招聘面试记录表
 */
public class RecruitmentRecord implements Serializable {

    private Integer id;
    private Integer recId;  //招聘id
    private Integer resId;   //简历id
    private String time;  //面试时间
    private Integer state;     // 1  表示  已经看过   0 没有 看过

    private Resume resume;

    public RecruitmentRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
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

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "RecruitmentRecord{" +
                "id=" + id +
                ", recId=" + recId +
                ", resId=" + resId +
                ", time='" + time + '\'' +
                ", state=" + state +
                ", resume=" + resume +
                '}';
    }
}
