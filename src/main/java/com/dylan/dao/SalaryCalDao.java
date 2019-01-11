package com.dylan.dao;

import com.dylan.model.SalaryCal;
import com.dylan.model.SalaryTicket;

import java.util.List;
import java.util.Map;

public interface SalaryCalDao {

    //添加薪资结算
    boolean addSalaryCal(SalaryCal salaryCal);

    //通过 自增id  查看薪资结算
    SalaryCal querySalaryCalBy_id(int id);

    //查出 薪资结算表 中 结算的唯一时间
    List<String> queryAllSalaryCalby_time();

    //通过时间查看这个月有没有过 薪资结算
    List<SalaryCal> querySalaryCal(Map<String,Object> map);
}
