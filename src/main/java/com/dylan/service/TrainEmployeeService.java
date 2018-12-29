package com.dylan.service;

import com.dylan.model.Train;
import com.dylan.model.TrainEmployee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TrainEmployeeService {

    //添加员工培训
    boolean addTrainEmployee(String[] empIdList, Train train);

    //发布员工培训
    boolean updateTrainEmployee(int id);

    //删除员工培训
    boolean deleteTrainEmployee(int id);
    //修改员工培训    先不写

    //通过培训表id查询
    List<TrainEmployee> queryTrainEmployeeBy_tId(int id);

    //通过员工id 查询培训  只能查询已经发布的
    List<TrainEmployee> queryTrainEmployeeBy_empId(int empId);

    //通过员工id 查询培训  只能查询已经发布的 分页
    List<TrainEmployee> queryTrainEmployeeBy_empId_evereyPage(int empId,int currentPage);

    //查看所有的员工培训
    Set<Train> queryAllTrainEmployee();

    //查看所有的员工培训  分页
    Map<String,Object> queryAllTrainEmployee_everyPage(int currentPage);

    //查看所有的员工培训 是否发布的
    Set<Train> queryAllTrainEmployeeBy_state_(int state);

    //查看所有的员工培训  是否发布的 分页
    Map<String,Object> queryAllTrainEmployeeBy_state_everyPage_(int currentPage,int state);

}
