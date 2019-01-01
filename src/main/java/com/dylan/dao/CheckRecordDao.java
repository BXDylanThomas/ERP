package com.dylan.dao;

import com.dylan.model.CheckRecord;

import java.util.List;
import java.util.Map;

public interface CheckRecordDao {

    //上班添加 考勤表  或者 没有上班时间时，进行下班打卡
    boolean addCheckRecord(CheckRecord checkRecord);

    //有上班时间  进行下班打卡
    boolean updateCheckRecord(CheckRecord checkRecord);

    //查询员工当天是否有上班打卡
    CheckRecord queryCheckRecord(Map<String,Object> map);

    //得到最近一次的登录记录表 根据员工id
    CheckRecord queryCheckRecordLast(int empId);

    //计算某员工 某月  没有旷工的 总天数  员工id  月份id
    Integer countWorkTime(Map<String,Object> map);

    //通过员工id 查询打卡记录
    List<CheckRecord> queryCheckRecordBY_empId_everyMonth(Map<String,Object> map);
}
