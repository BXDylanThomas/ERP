package com.dylan.service;

import com.dylan.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //办理  转正  或离职
    boolean updateEmployee(Employee employee);

    //查询所有的员工
    List<Employee> queryAllEmployee();

    //查询所有的员工 分页
    List<Employee> queryAllEmployeeBy_everyPage(int currentPage);

    //查询某部门的所有员工
    List<Employee> queryEmployeeBy_depId(int depId);

    //查询某部门的所有员工 分页
    List<Employee> queryEmployeeBy_depId_evertPage(int depId,int currentPage);

    //查询某职位的所有员工
    List<Employee> queryEmployeeBy_posId(int posId);

    //查询某职位的所有员工  分页
    List<Employee> queryEmployeeBy_posId_everyPage(int posId,int currentPage);
}
