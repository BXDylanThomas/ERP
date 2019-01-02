package com.dylan.service;

import com.dylan.model.Employee;
import com.dylan.model.EmployeeLeave;
import com.dylan.model.TrainDepartment;
import com.dylan.model.TrainEmployee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //办理  转正
    boolean updateEmployee(int empId);

    //办理  离职
    boolean updateEmployeeLeave(EmployeeLeave employeeLeave);

    //换岗
    boolean updateEmployeePosition(int empId,int posId);

    //通过账号账号id  查询某员工的具体信息
    Employee queryEmployeeBy_accId(int accId);

    //通过账号账号id  查询某员工的具体信息
    Employee queryEmployeeBy_empId(int empId);


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

    //查看部门培训
    List<TrainDepartment> queryTrainDepartment(int accId);

    //查看部门培训  分页
    List<TrainDepartment> queryTrainDepartment_everyPage(int accId,int current);

    //查看个人培训
    List<TrainEmployee> queryTrainEmployee(int accId);

    //查看个人培训
    List<TrainEmployee> queryTrainEmployee_everyPage(int accId,int current);

}
