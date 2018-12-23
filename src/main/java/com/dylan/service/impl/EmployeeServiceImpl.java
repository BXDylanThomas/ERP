package com.dylan.service.impl;

import com.dylan.dao.DimissionDao;
import com.dylan.dao.EmployeeDao;
import com.dylan.model.Dimission;
import com.dylan.model.Employee;
import com.dylan.service.EmployeeService;
import com.dylan.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DimissionDao dimissionDao;

    /**
     * 添加员工
     * 传入的由 姓名  性别 年龄  电话  邮箱 地址
     * 需要添加的 有   初始密码   入职时间   状态 （实习）
     * @param employee
     * @return
     */
    @Override
    public boolean addEmployee(Employee employee) {
        if(employee==null || employee.getName()==null){
            return false;
        }
        employee.setPassword(StateUtil.initialPassword);
        employee.setEntryTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        employee.setState(StateUtil.trainee);
        return employeeDao.addEmployee(employee);
    }

    /**
     * 员工登录
     * @param employee
     * @return
     */
    @Override
    public Employee queryEmployee(Employee employee) {
        if(employee==null || employee.getName()==null || employee.getPassword()==null){
            return null;
        }
        return employeeDao.queryEmployee(employee);
    }

    /**
     * 更新员工的基本信息
     * 包括  名字  电话  邮箱  地址
     * @param employee
     * @return
     */
    @Override
    public boolean updateEmployee(Employee employee) {
        if(employee==null){
            return false;
        }
        return employeeDao.updateEmployee(employee);
    }

    /**
     * 员工修改密码
     * @return
     */
    @Override
    public boolean updateEmployeeBy_password(int empId,String password) {
        if(empId<=0 || password==null || password.equals("")){
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("empId",empId);
        map.put("password",password);
        return employeeDao.updateEmployeeBy_password(map);
    }

    /**
     * 办理转正
     *  state = 1
     * @return
     */
    @Override
    public boolean updateEmployeeBy_regular(int empId) {
        if(empId<=0){
            return false;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("empId",empId);
        map.put("state",StateUtil.regular);
        return employeeDao.updateEmployeeBy_state(map);
    }
    /**
     *  离职
     *  state = -1  办理离职
     *  办理离职  生成一张离职表 记录
     *  description  是 离职原因
     * @param empId
     * @return
     */
    @Override
    public boolean updateEmployeeBy_dimission(int empId, String description) {
        if(empId<=0 || description==null || description==""){
            return false;
        }
        Employee employee = employeeDao.queryEmployeeBy_id(empId);

        Dimission dimission=new Dimission();
        dimission.setEmpId(empId);
        dimission.setDepId(employee.getDepartment().getId());
        dimission.setPosId(employee.getPosition().getId());
        dimission.setEntryTime(employee.getEntryTime());
        dimission.setOutTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        dimission.setDescription(description);

        Map<String, Object> map = new HashMap<>();
        map.put("empId",empId);
        map.put("state",StateUtil.dimission);

        boolean res1 = employeeDao.updateEmployeeBy_state(map);
        boolean res2 = dimissionDao.addDimission(dimission);
        return res1 && res2;
    }

    /**
     * 通过  员工id  查询
     * @param empId
     * @return
     */
    @Override
    public Employee queryEmployeeBy_id(int empId) {
        if(empId<=0){
            return null;
        }
        return employeeDao.queryEmployeeBy_id(empId);
    }

    /**
     * 查询  某部门 的所有员工
     * @param depId
     * @return
     */
    @Override
    public List<Employee> queryEmployeeBy_depId(int depId) {
        if(depId<=0){
            return null;
        }
        Map<String, Object> map = StateUtil.getMap();
        map.put("depId",depId);
        return employeeDao.queryEmployeeBy_depId(map);
    }

    @Override
    public List<Employee> queryEmployeeBy_depId_everyPage(int depId, int currentPage) {
        return null;
    }

    @Override
    public List<Employee> queryEmployeeBy_depId_posId(int depId, int posId) {
        return null;
    }

    @Override
    public List<Employee> queryEmployeeBy_depId_posId_everyPage(int depId, int posId, int currentPage) {
        return null;
    }
}
