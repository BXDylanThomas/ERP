package com.dylan.service;

import com.dylan.model.CheckRecord;

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
    Map<String, Object> queryCheckRecordBY_empId_everyMonth(int accId);

    //查看上月的打卡记录
    Map<String, Object> queryCheckRecordBY_empId_preMonth(int accId);
}
