package com.dylan.dao;

import com.dylan.model.Employee;
import com.dylan.model.TrainDepartment;
import com.dylan.model.TrainEmployee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    //添加员工
    boolean addEmployee(Employee employee);

    //换岗
    boolean updateEmployeePosition(Map<String,Object> map);

    //办理  转正  或离职
    boolean updateEmployee(Map<String,Object> map);

    //通过账号账号id  查询某员工的具体信息
    Employee queryEmployeeBy_accId(int accId);

    //通过账号账号id  查询某员工的具体信息
    Employee queryEmployeeBy_empId(int empId);

    //查询所有的员工 非离职
    List<Employee> queryAllEmployee();

    //查询所有的员工 非离职 分页
    List<Employee> queryAllEmployeeBy_everyPage(Map<String,Object> map);

    //查询某部门的所有员工 非离职
    List<Employee> queryEmployeeBy_depId(int depId);

    //查询某部门的所有员工 非离职 分页
    List<Employee> queryEmployeeBy_depId_evertPage(Map<String,Object> map);

    //查询某职位的所有员工 非离职
    List<Employee> queryEmployeeBy_posId(int posId);

    //查询某职位的所有员工 非离职  分页
    List<Employee> queryEmployeeBy_posId_everyPage(Map<String,Object> map);

    //查看员工的部门培训
    List<TrainDepartment> queryTrainDepartment(int accId);

    //查看员工的部门培训   分页
    List<TrainDepartment> queryTrainDepartment_everyPage(Map<String,Object> map);

    //查看员工的个人培训
    List<TrainEmployee> queryTrainEmployee(int accId);

    //查看员工的个人培训 分页
    List<TrainEmployee> queryTrainEmployee_everyPage(Map<String,Object> map);

}
