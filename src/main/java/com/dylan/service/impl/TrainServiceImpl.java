package com.dylan.service.impl;

import com.dylan.dao.TrainDao;
import com.dylan.model.Train;
import com.dylan.service.TrainService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    /**
     * 添加培训
     * @param train
     * @return
     */
    @Override
    public boolean addTrain(Train train) {
        if(train==null){
            return false;
        }
        return trainDao.addTrain(train);
    }

    @Override
    public boolean updateTrain(Train train) {
        if(train==null || train.getId()<=0){
            return false;
        }
        return trainDao.updateTrain(train);
    }

    @Override
    public boolean deleteTrain(int id) {
        if(id<=0){
            return false;
        }
        return trainDao.deleteTrain(id);
    }

    @Override
    public Train queryTrainBy_id(int id) {
        if(id<=0){
            return null;
        }
        return trainDao.queryTrainBy_id(id);
    }

    @Override
    public List<Train> queryAllTrain() {
        return trainDao.queryAllTrain();
    }

    @Override
    public List<Train> queryAllTrainBy_everyPage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map= PagesUtil.getPage(map,currentPage);
        return trainDao.queryAllTrainBy_everyPage(map);
    }
}
