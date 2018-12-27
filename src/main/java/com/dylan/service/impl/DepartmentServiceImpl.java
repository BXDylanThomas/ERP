package com.dylan.service.impl;

import com.dylan.dao.DepartmentDao;
import com.dylan.dao.PositionDao;
import com.dylan.model.Department;
import com.dylan.model.Position;
import com.dylan.service.DepartmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private PositionDao positionDao;
    /**
     * 添加部门  需要判断名字是否重复
     * @param department
     * @return
     */
    @Override
    public boolean addDepartment(Department department) {
        if(department==null || department.getName()==null || department.getName().equals("")){
            return false;
        }
        System.out.println(department);
        if(queryDepartmentBy_name(department.getName())){
            department.setCreateTime(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
            return departmentDao.addDepartment(department);
        }

        return false;
    }

    /**
     * 更新名字之前也需要查询 名字  是否重复
     * 如果修改的和之前的名字相同 直接返回true
     * @param department
     * @return
     */
    @Override
    public boolean updateDepartment(Department department) {
        if(department==null || department.getId()<=0 || department.getName()==null){
            return false;
        }
        System.out.println(department);
        if(departmentDao.queryDepartmentBy_name(department.getName())!=null){
            return true;
        }
        if(queryDepartmentBy_name(department.getName())){
            return departmentDao.updateDepartment(department);
        }
        return false;
    }

    /**
     * 删除部门
     * 如果之下存在职位  则不能进行删除
     * @param depId
     * @return
     */
    @Override
    public boolean deleteDepartment(int depId) {
        if(depId<=0){
            return false;
        }
        List<Position> positions = positionDao.queryAllPosition();
        for(Position p:positions){
            if(p.getDepId()==depId){
                return false;
            }
        }
        return departmentDao.deleteDepartment(depId);
    }

    /**
     * 判断  部门名称是否重复
     * @param name
     * @return
     */
    @Override
    public boolean queryDepartmentBy_name(String name) {
        if(name==null || name.equals("")){
            return false;
        }
        //true  名字不重复    可以添加    false  相反  不能添加
        return departmentDao.queryDepartmentBy_name(name)==null?true:false;
    }

    /**
     * 通过部门id 查询部门
     * @param depId
     * @return
     */
    @Override
    public Department queryDepartmentBy_depId(int depId) {
        if(depId<=0){
            return null;
        }
        return departmentDao.queryDepartmentBy_depId(depId);
    }

    /**
     * 得到所有部门
     * @return
     */
    @Override
    public List<Department> queryAllDepartment() {
        return departmentDao.queryAllDeprtment();
    }

    /**
     * 分页查询所有部门
     * @param currentPage
     * @return
     */
    @Override
    public List<Department> queryAllDepartmentBy_everypage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map = PagesUtil.getPage(map, currentPage);
        return departmentDao.queryAllDeprtmentBy_everypage(map);
    }
}
