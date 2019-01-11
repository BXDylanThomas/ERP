package com.dylan.dao;

import com.dylan.model.EmployeeLeave;

import java.util.List;
import java.util.Map;

public interface EmployeeLeaveDao {

    //添加离职员工记录表
    boolean addEmployeeLeave(EmployeeLeave employeeLeave);

    //查看所有的离职员工
    List<EmployeeLeave> queryEmployeeLeave();

    //查看所有的离职员工  分页
    List<EmployeeLeave> queryEmployeeLeave_everyPage(Map<String,Object> map);
}
