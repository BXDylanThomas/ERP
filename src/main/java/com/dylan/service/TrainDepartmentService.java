package com.dylan.service;

import com.dylan.model.Train;
import com.dylan.model.TrainDepartment;

import java.util.List;
import java.util.Map;

public interface TrainDepartmentService {

    //添加部门培训
    boolean addTrainDepartment(Train train,int depId);

    //发布部门培训
    boolean updateDepartment(int id);

    boolean updateDepartmentby_depId(int tdId,int depId,Train train);

    //通过id查询
    TrainDepartment queryTrainDepartmentBy_id(int id);

    //删除
    boolean deleteDeTrainDepartment(int id);

    //查询所有部门的培训
    List<TrainDepartment> queryAllTrainDepartment();

    //查询所有部门的培训  分页
    List<TrainDepartment> queryAllTrainDepartmentBy_everyPage(int currentPage);

    //查询所有 是否  发布的
    List<TrainDepartment> queryAllTrainDepartment_send(int state);

    //查询所有是否发布的   分页
    List<TrainDepartment> queryAllTrainDepartment_send_everyPage(int state,int currentPage);

    //查询某部门的所有培训
    List<TrainDepartment> queryAllTrainDepartmentBy_depId(int depId);

    //查询某部门的所有培训 分页
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_everyPage(int depId,int currentPage);

    //查询某部门的所有培训  是否 发布的
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_send(int depId,int state);

    //查询某部门的所有培训  是否 发布的   分页
    List<TrainDepartment> queryAllTrainDepartmentBy_depId_send_everyPage(int depId,int state,int currentPage);
}
