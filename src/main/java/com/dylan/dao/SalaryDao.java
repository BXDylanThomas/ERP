package com.dylan.dao;

import com.dylan.model.Salary;

public interface SalaryDao {

    //添加基本薪资记录
    boolean addSalary(Salary salary);

    //通过简历id查询
    Salary querySalaryBy_resId(int resId);
}
