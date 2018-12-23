package com.dylan.dao;

import com.dylan.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    //添加员工
    boolean addEmployee(Employee employee);

    //员工登录
    Employee queryEmployee(Employee employee);

    //更新员工基本信息信息   入职时间不能换
    boolean updateEmployee(Employee employee);

    //修改密码
    boolean updateEmployeeBy_password(Map<String,Object> map);
    //给员工办理 转正   或  离职
    boolean updateEmployeeBy_state(Map<String,Object> map);

    //根据员工id 查找员工
    Employee queryEmployeeBy_id(int empId );

    //查询某部门的员工
    List<Employee> queryEmployeeBy_depId(Map<String,Object> map);

    //查询某部门的员工  分页
    List<Employee>  queryEmployeeBy_depId_everypage(Map<String,Object> map);

    //查询某部门某职位的员工
    List<Employee> queryEmployeeBy_depId_posId(Map<String,Object> map);

    //查询某部门某职位的员工  分页
    List<Employee> queryEmployeeBy_depId_posId_everyPage(Map<String,Object> map);


}
