package com.dylan.service;

import com.dylan.model.CheckRecord;
import com.dylan.model.PrizeRecord;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface CheckRecordService {

    //上班打卡
    boolean workCheckIn(int accId) throws ParseException;

    //查看今天有没有上班打卡
    CheckRecord queryCheckRecordIsCheck(int accId);
    //下班打卡
    boolean offCheckOut(int accId) throws ParseException;

    //查看当月的打卡记录
    Map<String, Object> queryCheckRecordBY_empId_everyMonth(int empId);

    //查看上月的打卡记录
    Map<String, Object> queryCheckRecordBY_empId_preMonth(int empId);

    //通过员工id 查看的所有奖惩记录表
    List<PrizeRecord> queryAllPrizeRecordBy_empId(int empId);

    //通过员工id 查看的所有奖惩记录表  分页
    List<PrizeRecord> queryAllPrizeRecordBy_empId_everyPage(int empId,int currentPage);
}
