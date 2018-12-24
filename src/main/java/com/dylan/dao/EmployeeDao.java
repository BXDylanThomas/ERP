package com.dylan.dao;

import com.dylan.model.Employee;

public interface EmployeeDao {

    //添加员工
    boolean addEmployee(Employee employee);

    //办理  转正  或离职
    boolean updateEmployee();


}
