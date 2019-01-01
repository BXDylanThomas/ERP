package com.dylan.dao;

import com.dylan.model.PrizeRecord;

public interface PrizeRecordDao {

    //添加奖惩记录表
    boolean addPrizeReocrd(PrizeRecord prizeRecord);

    //修改奖惩记录表
    boolean updatePrizeRecord(PrizeRecord prizeRecord);

    //查询奖惩记录表 员工id   时间  如果当天已经有了迟到记录 又有了旷工
}
