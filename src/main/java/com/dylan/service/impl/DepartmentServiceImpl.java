package com.dylan.service.impl;

import com.dylan.dao.DepartmentDao;
import com.dylan.model.Department;
import com.dylan.service.DepartmentService;
import com.dylan.util.PagesUtil;
import com.dylan.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 添加部门  添加之前需要检查  部门名称 是否 重复
     * 传进来的数据有  部门名称  描述
     * 需要添加  创建时间  state = 1
     * @param department
     * @return
     */
    @Override
    public boolean addDepartment(Department department) {
        if(department==null || department.getName()==null){
            return false;
        }
        if(!queryDepartmentBy_name(department.getName())){
            return false;
        }
        //准备添加
        department.setCreateTime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        department.setState(StateUtil.regular);
        return departmentDao.addDepartment(department);
    }

    /**
     * 查询部门名称是否重复
     * @param name
     * @return
     */
    @Override
    public boolean queryDepartmentBy_name(String name) {
        if(name==null){
            return false;
        }
        Department department = departmentDao.queryDepartmentBy_name(name);
        //department ==  null   说明  不存在该部门  可以添加    ！=null  则相反 不能添加
        return department==null?true:false;
    }

    /**
     * 传进来的有  部门id   部门名称  描述
     * 更新信息  只能更新部门名称  描述
     * 如果更新部门名称  需要检查名称是否重复
     * @param department
     * @return
     */
    @Override
    public boolean updateDepartment(Department department) {
        if(department==null || department.getName()==null){
            return false;
        }
        Map<String,Object> map=StateUtil.getMap();
        map.put("depId",department.getId());
        //通过id 查询  部门
        Department dep = departmentDao.queryDepartmentBy_id(map);
        //如果部门名称不同，说明 部门名称有修改  需要检查是否重复
        if(!dep.getName().equals(department.getName())){
            //是true   可以更换部门名称
            return queryDepartmentBy_name(department.getName()) ? departmentDao.updateDepartment(department) : false;
        }else{
            //只是更新部门描述
            return departmentDao.updateDepartment(department);
        }
    }

    /**
     * id 是 部门id
     * 删除部门   把部门的 state = -1
     * @param id
     * @return
     */
    @Override
    public boolean updateDepartmentBy_delete(int id) {
        if(id<=0){
            return false;
        }
        Map<String,Object> map=StateUtil.getMap();
        map.put("depId",id);
        return departmentDao.updateDepartmentBy_delete(map);
    }

    /**
     * 查询所有部门  为了得到部门 总共可以分多少页  得到size   在职员工
     * @return
     */
    @Override
    public List<Department> queryAllDepartment() {
        Map<String,Object> map=StateUtil.getMap();
        return departmentDao.queryAllDepartment(map);
    }

    /**
     * 分页查询
     * @param currentPages
     * @return
     */
    @Override
    public List<Department> queryDepartmentBy_everyPage(int currentPages) {
        if( currentPages<=0){
            return null;
        }
        Map<String,Object> map=StateUtil.getMap();
        map=PagesUtil.getPage(map,currentPages);
        return departmentDao.queryDepartmentBy_everyPage(map);
    }

    /**
     * 通过id 查询部门
     * @param id
     * @return
     */
    @Override
    public Department queryDepartmentBy_id(int id) {
        Map<String,Object> map=StateUtil.getMap();
        map.put("depId",id);
        return departmentDao.queryDepartmentBy_id(map);
    }
}
