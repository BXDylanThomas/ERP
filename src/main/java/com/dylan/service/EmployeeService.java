package com.dylan.service;

import com.dylan.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //添加新员工
    boolean addEmployee(Employee employee);

    //员工登录
    Employee queryEmployee(Employee employee);

    //更新员工基本信息信息   入职时间不能换
    boolean updateEmployee(Employee employee);

    //修改密码
    boolean updateEmployeeBy_password(int empId,String password);

    //给员工办理 转正
    boolean updateEmployeeBy_regular(int empId);

    //给员工办理 离职
    boolean updateEmployeeBy_dimission(int empId,String description);

    //根据员工id 查找员工
    Employee queryEmployeeBy_id(int empId );

    //查询某部门的员工
    List<Employee> queryEmployeeBy_depId(int depId);

    //查询某部门的员工  分页
    List<Employee>  queryEmployeeBy_depId_everyPage(int depId,int currentPage);

    //查询某部门某职位的员工
    List<Employee> queryEmployeeBy_depId_posId(int depId,int posId);

    //查询某部门某职位的员工  分页
    List<Employee> queryEmployeeBy_depId_posId_everyPage(int depId,int posId,int currentPage);

}
