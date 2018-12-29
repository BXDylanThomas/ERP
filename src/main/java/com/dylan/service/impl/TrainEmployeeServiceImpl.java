package com.dylan.service.impl;

import com.dylan.dao.TrainDao;
import com.dylan.dao.TrainEmployeeDao;
import com.dylan.model.Train;
import com.dylan.model.TrainEmployee;
import com.dylan.service.TrainEmployeeService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrainEmployeeServiceImpl implements TrainEmployeeService {

    public final static int UNPUBLISH=0;

    @Autowired
    private TrainEmployeeDao  trainEmployeeDao;
    @Autowired
    private TrainDao trainDao;

    /**
     * 添加员工培训   员工id 的集合
     * @return
     */
    @Override
    public boolean addTrainEmployee(String[] empIdList,Train train) {
        if(empIdList==null || empIdList.length==0 ){
            return false;
        }
        boolean res = trainDao.addTrain(train);//添加员工培训表
        if(!res){
            return false;
        }
        boolean res2=false;
        for(String i:empIdList){
            TrainEmployee employee=new TrainEmployee();
            employee.setEmpId(Integer.parseInt(i));
            employee.settId(train.getId());
            employee.setState(UNPUBLISH);
            res2 = trainEmployeeDao.addTrainEmployee(employee);
            if(!res2){
                return false;
            }
        }
        return true;
    }

    /**
     * 发布员工招聘
     * @param id  是 培训表的id
     * @return
     */
    @Override
    public boolean updateTrainEmployee(int id) {
        if(id<=0){
            return false;
        }
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryTrainEmployeeBy_tId(id);
        if(trainEmployees==null || trainEmployees.isEmpty()){
            return false;
        }
        boolean res=false;
        for(TrainEmployee te:trainEmployees){
            res = trainEmployeeDao.updateTrainEmployee(te.getId());
            if(!res){
                return false;
            }
        }
        return true;
    }

    /**
     * 删除员工培训
     * @param id
     * @return
     */
    @Override
    public boolean deleteTrainEmployee(int id) {
        if(id<=0){
            return false;
        }
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryTrainEmployeeBy_tId(id);
        if(trainEmployees==null || trainEmployees.isEmpty()){
            return false;
        }
        boolean res=false;
        for(TrainEmployee te:trainEmployees){
            res = trainEmployeeDao.deleteTrainEmployee(te.getId());
            if(!res){
                return false;
            }
        }
        //删除培训表
        boolean res2 = trainDao.deleteTrain(id);
        return res2;
    }

    @Override
    public List<TrainEmployee> queryTrainEmployeeBy_tId(int id) {
        if(id<=0){
            return null;
        }
        return trainEmployeeDao.queryTrainEmployeeBy_tId(id);
    }

    /**
     * 查询某个员工的所有培训记录表
     * @param empId
     * @return
     */
    @Override
    public List<TrainEmployee> queryTrainEmployeeBy_empId(int empId) {
        if(empId<=0){
            return null;
        }
        return trainEmployeeDao.queryTrainEmployeeBy_empId(empId);
    }

    /***
     * 查询某个员工的所有培训记录表  分页
     * @param empId
     * @param currentPage
     * @return
     */
    @Override
    public List<TrainEmployee> queryTrainEmployeeBy_empId_evereyPage(int empId, int currentPage) {
        if(empId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("empId",empId);
        map= PagesUtil.getPage(map,currentPage);
        return trainEmployeeDao.queryTrainEmployeeBy_empId_evereyPage(map);
    }

    /**
     * 查询所有的员工培训记录表
     * @return
     */
    @Override
    public Set<Train> queryAllTrainEmployee() {
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryAllTrainEmployee();
        Set<Train> train=new TreeSet<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getId()-o2.getId();
            }
        });
        for(TrainEmployee te:trainEmployees) {
            train.add(te.getTrain());
        }
        return train;
    }

    /**
     * 查询所有的员工培训记录表  分页
     * @param currentPage
     * @return
     */
    @Override
    public Map<String,Object> queryAllTrainEmployee_everyPage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryAllTrainEmployee();
        return getNewOne(trainEmployees,currentPage);
    }

    /**
     * 通过 状态  查询所有的员工培训记录表
     * @param state
     * @return
     */
    @Override
    public Set<Train> queryAllTrainEmployeeBy_state_(int state) {
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryAllTrainEmployeeBy_state_(state);
        Set<Train> train=new TreeSet<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getId()-o2.getId();
            }
        });
        for(TrainEmployee te:trainEmployees) {
            train.add(te.getTrain());
        }
        return train;
    }

    /**
     * 通过 状态  查询所有的员工培训记录表   分页
     * @param currentPage
     * @param state
     * @return
     */
    @Override
    public Map<String,Object> queryAllTrainEmployeeBy_state_everyPage_(int currentPage, int state) {
        if(currentPage<=0){
            return null;
        }
        List<TrainEmployee> trainEmployees = trainEmployeeDao.queryAllTrainEmployeeBy_state_(state);
        return getNewOne(trainEmployees,currentPage);
    }

    /**
     * 员工培训的分页  恶心！
     * 先要得到所有的培训的id
     * @param trainEmployees
     * @param currentPage
     * @return
     */
    public Map<String,Object> getNewOne(List<TrainEmployee> trainEmployees,int currentPage){
        Set<Train> set=new TreeSet<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getId()-o2.getId();
            }
        });
        for(TrainEmployee te:trainEmployees){
            set.add(te.getTrain());
        }
        List<Train> list=new ArrayList<>(set);
        List<TrainEmployee> newList=new ArrayList<>();
        for(int i=(currentPage-1)*PagesUtil.SHOW;i<list.size() && i<currentPage*PagesUtil.SHOW;i++){
            for(TrainEmployee te:trainEmployees){
                if(te.getTrain().getId()==list.get(i).getId()){
                    newList.add(te);
                }
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("train",list);
        map.put("trainEmployees",newList);
        return map;
    }
}
