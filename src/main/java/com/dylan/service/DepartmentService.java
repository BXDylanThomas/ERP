package com.dylan.service;

import com.dylan.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    //添加部门
    boolean addDepartment(Department department);

    //查重部门名字 ，如果重复，不能添加
    boolean queryDepartmentBy_name(String name);

    //更新部门信息  如:修改名字
    boolean updateDepartment(Department department);

    //更新部门信息 将state == -1  删除职位
    boolean updateDepartmentBy_delete(int id);

    //查询所有部门  非删除部门
    List<Department> queryAllDepartment();

    //分页查询所有部门
    List<Department> queryDepartmentBy_everyPage( int currentPages);

    //通过id查询部门
    Department queryDepartmentBy_id(int id);

}
