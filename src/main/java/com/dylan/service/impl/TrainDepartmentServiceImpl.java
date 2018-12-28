package com.dylan.service.impl;

import com.dylan.dao.TrainDao;
import com.dylan.dao.TrainDepartmentDao;
import com.dylan.model.Train;
import com.dylan.model.TrainDepartment;
import com.dylan.service.TrainDepartmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainDepartmentServiceImpl implements TrainDepartmentService {

    public final static int UNPUBLISH=0;
    public final static int HASPUBLISH=1;
    @Autowired
    private TrainDepartmentDao trainDepartmentDao;
    @Autowired
    private TrainDao trainDao;

    /**
     * 添加部门培训
     * 先插入部门培训

     * @return
     */
    @Override
    public boolean addTrainDepartment(Train train, int depId) {
        if(train==null){
            return false;
        }
        boolean res1 = trainDao.addTrain(train);
        if(!res1){
            return false;
        }
        TrainDepartment trainDepartment=new TrainDepartment();
        trainDepartment.settId(train.getId());
        trainDepartment.setDepId(depId);
        trainDepartment.setState(UNPUBLISH);
        boolean res2 = trainDepartmentDao.addTrainDepartment(trainDepartment);
        return res1 && res2;
    }

    @Override
    public boolean updateDepartment(int id) {
        if(id<=0){
            return false;
        }
        return trainDepartmentDao.updateTrainDepartment(id);
    }

    @Override
    public boolean updateDepartmentby_depId(int tdId,int depId,Train train) {
        if(tdId<=0 || depId<=0 || train==null || train.getId()<=0){
            return false;
        }
        //修改培训部门
        Map<String,Object> map=new HashMap<>();
        map.put("depId",depId);
        map.put("tdId",tdId);
        boolean res1 = trainDepartmentDao.updateTrainDepartmentby_depId(map);

        //修改培训内容
        boolean res2 = trainDao.updateTrain(train);
        return res1 && res2;
    }

    @Override
    public TrainDepartment queryTrainDepartmentBy_id(int id) {
        if(id<=0){
            return null;
        }
        return trainDepartmentDao.queryTrainDepartmentBy_id(id);
    }

    @Override
    public boolean deleteDeTrainDepartment(int id) {
        if(id<=0){
            return false;
        }
        //删除部门培训记录表   同时删除该培训记录
        TrainDepartment trainDepartment = trainDepartmentDao.queryTrainDepartmentBy_id(id);
        boolean res = trainDao.deleteTrain(trainDepartment.gettId());
        return res && trainDepartmentDao.deleteDeTrainDepartment(id)  ;
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartment() {
        return trainDepartmentDao.queryAllTrainDepartment();
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartmentBy_everyPage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map= PagesUtil.getPage(map,currentPage);
        return trainDepartmentDao.queryAllTrainDepartmentBy_everyPage(map);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartment_send(int state) {
        return trainDepartmentDao.queryAllTrainDepartment_send(state);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartment_send_everyPage(int state, int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("state",state);
        map= PagesUtil.getPage(map,currentPage);
        return trainDepartmentDao.queryAllTrainDepartment_send_everyPage(map);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartmentBy_depId(int depId) {
        if(depId<=0){
            return null;
        }
       return trainDepartmentDao.queryAllTrainDepartmentBy_depId(depId);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartmentBy_depId_everyPage(int depId, int currentPage) {
        if(depId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("depId",depId);
        map= PagesUtil.getPage(map,currentPage);
        return trainDepartmentDao.queryAllTrainDepartmentBy_depId_everyPage(map);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartmentBy_depId_send(int depId, int state) {
        if(depId<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("depId",depId);
        map.put("state",state);
        return trainDepartmentDao.queryAllTrainDepartmentBy_depId_send(map);
    }

    @Override
    public List<TrainDepartment> queryAllTrainDepartmentBy_depId_send_everyPage(int depId, int state, int currentPage) {

        if(depId<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("depId",depId);
        map.put("state",state);
        map=PagesUtil.getPage(map,currentPage);
        return trainDepartmentDao.queryAllTrainDepartmentBy_depId_send_everyPage(map);
    }
}
