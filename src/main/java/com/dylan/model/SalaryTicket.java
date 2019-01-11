package com.dylan.model;

public class SalaryTicket {

    private Integer day;  //出勤天数
    private Double base;  //基本工资
    private Double performance;  //绩效
    private Double ot;   //加班工资
    private Double prize;  //奖励
    private Double punish;  //惩罚
    private Double social;  //社保
    private Double sum;

    public SalaryTicket() {
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Double getOt() {
        return ot;
    }

    public void setOt(Double ot) {
        this.ot = ot;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Double getPunish() {
        return punish;
    }

    public void setPunish(Double punish) {
        this.punish = punish;
    }

    public Double getSocial() {
        return social;
    }

    public void setSocial(Double social) {
        this.social = social;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }


    @Override
    public String toString() {
        return "SalaryTicket{" +
                "day=" + day +
                ", base=" + base +
                ", performance=" + performance +
                ", ot=" + ot +
                ", prize=" + prize +
                ", punish=" + punish +
                ", social=" + social +
                ", sum=" + sum +
                '}';
    }
}
