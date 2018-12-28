package com.dylan.model;

import java.io.Serializable;
import java.util.List;

/**
 * 培训表
 */
public class Train implements Serializable {

    private Integer id;
    private String title;  //培训标题
    private String content;  //培训内容
    private String address;  //培训地址
    private String startTime;  //培训开始时间
    private String endTime;   //培训结束时间

    private List<TrainEmployee>  trainEmployees;

    public Train() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<TrainEmployee> getTrainEmployees() {
        return trainEmployees;
    }

    public void setTrainEmployees(List<TrainEmployee> trainEmployees) {
        this.trainEmployees = trainEmployees;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", trainEmployees=" + trainEmployees +
                '}';
    }
}
