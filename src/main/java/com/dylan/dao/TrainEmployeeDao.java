package com.dylan.dao;

import com.dylan.model.TrainEmployee;

import java.util.List;
import java.util.Map;

public interface TrainEmployeeDao {

    //添加员工培训
    boolean addTrainEmployee(TrainEmployee trainEmployee);

    //发布员工培训
    boolean updateTrainEmployee(int id);

    //删除员工培训
    boolean deleteTrainEmployee(int id);
    //修改员工培训    先不写

    //根据 培训表id 查询所有的
    List<TrainEmployee> queryTrainEmployeeBy_tId(int tId);

    //通过员工id 查询培训  只能查询已经发布的
    List<TrainEmployee> queryTrainEmployeeBy_empId(int empId);

    //通过员工id 查询培训  只能查询已经发布的 分页
    List<TrainEmployee> queryTrainEmployeeBy_empId_evereyPage(Map<String,Object> map);

    //查看所有的员工培训
    List<TrainEmployee> queryAllTrainEmployee();

    //查看所有的员工培训  分页
    List<TrainEmployee> queryAllTrainEmployee_everyPage(Map<String,Object> map);

    //查看所有的员工培训 是否发布的
    List<TrainEmployee> queryAllTrainEmployeeBy_state_(int state);
    //查看所有的员工培训  是否发布的 分页
    List<TrainEmployee> queryAllTrainEmployeeBy_state_everyPage_(Map<String,Object> map);
}
