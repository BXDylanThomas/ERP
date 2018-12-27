package com.dylan.service.impl;

import com.dylan.dao.EmployeeDao;
import com.dylan.model.Employee;
import com.dylan.service.EmployeeService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 转正  或者   离职
     * @param employee
     * @return
     */
    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    /**
     *   通过账号账号id  查询某员工的具体信息
     *
     * @param accId
     * @return
     */
    @Override
    public Employee queryEmployeeBy_accId(int accId) {
        if(accId<=0){
            return null;
        }
        return employeeDao.queryEmployeeBy_accId(accId);
    }

    /**
     * 查看所有的员工
     * @return
     */
    @Override
    public List<Employee> queryAllEmployee() {
        return employeeDao.queryAllEmployee();
    }

    /**
     * 查看所有的员工  分页
     * @param currentPage
     * @return
     */
    @Override
    public List<Employee> queryAllEmployeeBy_everyPage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map = PagesUtil.getPage(map, currentPage);

        return employeeDao.queryAllEmployeeBy_everyPage(map);
    }

    @Override
    public List<Employee> queryEmployeeBy_depId(int depId) {
        if(depId<=0){
            return null;
        }
        return employeeDao.queryEmployeeBy_depId(depId);
    }

    @Override
    public List<Employee> queryEmployeeBy_depId_evertPage(int depId, int currentPage) {
        if(depId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
         map = PagesUtil.getPage(map, currentPage);
        map.put("depId",depId);
        return employeeDao.queryEmployeeBy_depId_evertPage(map);
    }

    @Override
    public List<Employee> queryEmployeeBy_posId(int posId) {
        if(posId<=0){
            return null;
        }
        return employeeDao.queryEmployeeBy_posId(posId);
    }

    @Override
    public List<Employee> queryEmployeeBy_posId_everyPage(int posId, int currentPage) {
        if(posId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("posId",posId);
        map = PagesUtil.getPage(map, currentPage);
        return employeeDao.queryEmployeeBy_posId_everyPage(map);
    }
}
