package com.dylan.service;

import com.dylan.model.PrizeRecord;
import com.dylan.model.SalaryReview;
import com.dylan.model.SalaryTicket;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface SalaryCalService {

    //进行薪资结算
    boolean addSalaryCal() throws ParseException;

    //工资复议
    boolean reviewSalary(int id,SalaryReview review);

    //查看所有的薪资复议
    List<SalaryReview> queryAllSalaryReview();

    //查看所有的薪资复议  分页
    List<SalaryReview> queryAllSalaryReview_everyPage(int currentPage);

    //查询所有的薪资结算 通过员工id 每个月的
    List<SalaryTicket> querySalaryTicketBy_empId(int empId) throws ParseException;

    //拒绝复议申请
    boolean salaryReviewsRefuse(int id);

    //同意  并且生成奖励记录
    boolean sure(int id, PrizeRecord prizeRecord);
}
