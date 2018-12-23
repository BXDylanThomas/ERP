package com.dylan.dao;

import com.dylan.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    //添加部门
    boolean addDepartment(Department department);

    //查重部门名字 ，如果重复，不能添加
    Department queryDepartmentBy_name(String name);

    //更新部门信息  如:修改名字  如果有state == -1  表示删除职位
    boolean updateDepartment(Department department);

    //更新部门信息 将state == -1
    boolean updateDepartmentBy_delete(Map<String,Object> map);

    //查询所有部门
    List<Department> queryAllDepartment(Map<String,Object> map);

    //分页查询所有部门
    List<Department> queryDepartmentBy_everyPage(Map<String,Object> map);

    //通过id查询部门
    Department queryDepartmentBy_id(Map<String,Object> map);
}
