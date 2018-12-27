package com.dylan.model;

import java.io.Serializable;

public class Salary implements Serializable {

    private Integer id;
    private Integer resId;
    private Double money;

    public Salary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", resId=" + resId +
                ", money=" + money +
                '}';
    }
}
