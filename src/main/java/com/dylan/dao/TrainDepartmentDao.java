package com.dylan.dao;

import com.dylan.model.TrainDepartment;

import java.util.List;
import java.util.Map;

public interface TrainDepartmentDao {

    //添加部门培训
    boolean addTrainDepartment(TrainDepartment trainDepartment);

    //发布部门培训
    boolean updateTrainDepartment(int id);

    //修改培训内容
    boolean updateTrainDepartmentby_depId(Map<String,Object> map);

    //通过id查询
    TrainDepartment queryTrainDepartmentBy_id(int id);
    //删除
    boolean deleteDeTrainDepartment(int id);
    //查询所有部门的培训
    List<TrainDepartment> queryAllTrainDepartment();

    //查询所有部门的培训  分页
    List<TrainDepartment> queryAllTrainDepartmentBy_everyPage(Map<String,Object> map);

    //查询所有 是否  发布的
    List<TrainDepartment> queryAllTrainDepartment_send(int state);

    //查询所有是否发布的   分页
    List<TrainDepartment> queryAllTrainDepartment_send_everyPage(Map<String,Object> map);

    //查询某部门的所有培训
    List<TrainDepartment> queryAllTrainDepartmentBy_depId(int depId);

    //查询某部门的所有培训 分页
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_everyPage(Map<String,Object> map);

    //查询某部门的所有培训  是否 发布的
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_send(Map<String,Object> map);

    //查询某部门的所有培训  是否 发布的   分页
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_send_everyPage(Map<String,Object> map);

}
