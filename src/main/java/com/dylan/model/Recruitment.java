package com.dylan.model;

import javafx.geometry.Pos;

import java.util.List;

/**
 * 招聘
 */
public class Recruitment {

    private Integer id;
    private Integer posId;
    private String title;
    private String content;
    private Integer count;
    private String createTime;

    private Position positions;


    public Recruitment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", posId=" + posId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                ", createTime='" + createTime + '\'' +
                ", positions=" + positions +
                '}';
    }
}
