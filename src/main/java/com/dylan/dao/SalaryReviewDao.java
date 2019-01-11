package com.dylan.dao;

import com.dylan.model.SalaryReview;

import java.util.List;
import java.util.Map;

public interface SalaryReviewDao {

    //添加工资复议
    boolean addSalaryReview(SalaryReview salaryReview);

    //更新薪资复议
    boolean updateSalaryReview(Map<String,Object> map);

    //查看所有的薪资复议
    List<SalaryReview> queryAllSalaryReview();

    //查看所有的薪资复议  分页
    List<SalaryReview> queryAllSalaryReview_everyPage(Map<String,Object> map);
}
