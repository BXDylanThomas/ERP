package com.dylan.dao;

import com.dylan.model.PrizeRecord;

import java.util.List;
import java.util.Map;

public interface PrizeRecordDao {

    //添加奖惩记录表
    boolean addPrizeRecord(PrizeRecord prizeRecord);

    //修改奖惩记录表
    boolean updatePrizeRecord(PrizeRecord prizeRecord);

    //查看员工当天的奖惩记录表
    PrizeRecord queryPrizeRecordBy_empId(Map<String,Object> map);

    //通过员工id 查看的所有奖惩记录表
    List<PrizeRecord> queryAllPrizeRecordBy_empId(int empId);

    //通过员工id 查看的所有奖惩记录表  分页
    List<PrizeRecord> queryAllPrizeRecordBy_empId_everyPage(Map<String,Object> map);


}
