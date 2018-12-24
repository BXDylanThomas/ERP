package com.dylan.dao;

import com.dylan.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    //添加部门
    boolean addDepartment(Department department);

    //更新部门名字
    boolean updateDepartment(Department department);

    //删除部门
    boolean deleteDepartment(int depId);


    //通过名字查询部门  判断是否重复
    Department queryDepartmentBy_name(String name);

    //通过 id   查询部门
    Department queryDepartmentBy_depId(int depId);

    //查询所有部门
    Integer  queryAllDeprtment();

    //查询所有部门分页
    List<Department>  queryAllDeprtmentBy_everypage(Map<String,Object> map);

}
