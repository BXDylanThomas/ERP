package com.dylan.dao;

import com.dylan.model.Train;

import java.util.List;
import java.util.Map;

public interface TrainDao {

    //添加培训
    boolean addTrain(Train train);

    //修改培训
    boolean updateTrain(Train train);

    //删除培训
    boolean deleteTrain(int id);

    //通过id查询培训
    Train queryTrainBy_id(int id);

    //查询所有的培训
    List<Train> queryAllTrain();

    //查询所有的培训分页
    List<Train> queryAllTrainBy_everyPage(Map<String,Object> map);
}
