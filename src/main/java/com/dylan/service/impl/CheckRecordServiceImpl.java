package com.dylan.service.impl;

import com.dylan.dao.CheckRecordDao;
import com.dylan.dao.EmployeeDao;
import com.dylan.dao.PrizeRecordDao;
import com.dylan.model.CheckRecord;
import com.dylan.model.Employee;
import com.dylan.service.CheckRecordService;
import oracle.sql.DATE;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CheckRecordServiceImpl implements CheckRecordService {
    public final static String WORKTIME="09:00";
    public final static String LATETIME="12:00";
    public final static String EARLYTIME="15:00";
    public final static String OFFTIME="18:00";

    public final static int regular=1;  //正常
    public final static int late=2;  //迟到
    public final static int early=3;  //早退
    public final static int absenteeism=4;  //旷工


    public final static int normal=0;  //正常
    public final static int overTIme=1;  //加班
    public final static int monthDay=22;  //加班基准

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");

    //转化为时间格式
    static Date workTime=null;
    static Date lateTime=null;
    static Date earlyTime=null;
    static Date offTime=null;

    static {
        try {
            workTime=simpleDateFormat.parse(WORKTIME);
            lateTime=simpleDateFormat.parse(LATETIME);
            earlyTime=simpleDateFormat.parse(EARLYTIME);
            offTime=simpleDateFormat.parse(OFFTIME);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CheckRecordDao checkRecordDao;

    @Autowired
    private PrizeRecordDao prizeRecordDao;

    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 上班打卡
     *
     * 1. 正常上班
     * 2.在 9:00--12:00 之间打卡  算迟到
     * 3.在12:00 后打卡 算旷工
     * @param accId
     * @return
     */
    @Override
    public boolean workCheckIn(int accId) throws ParseException {
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);

        /**
         * 判断当月上班有没有大于22 天  有上班时间或者下班时间  说明今天来了 并且当天不是旷工
         * 如果 大于22天  算加班  需要添加 加班 奖励表
         *如果  小于22天  正常上班  没有加班之说
         */
        Date date=new Date();
        Map<String,Object> map=getMonth(date);
        map.put("empId",employee.getId());
        Integer count = checkRecordDao.countWorkTime(map);

        CheckRecord checkRecord=new CheckRecord();
        checkRecord.setEmpId(employee.getId());

        String work=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        checkRecord.setWorkTime(work);
        checkRecord.setOffTime("");

        //设定是否加班  大于22天  设定为  overtime
        checkRecord.setOverTime(count>monthDay?overTIme:normal);

        //正常上班 小于等于 9:00
        String hour=simpleDateFormat.format(date);
        Date time = simpleDateFormat.parse(hour);

        if(time.before(workTime) || time.equals(workTime)){
            checkRecord.setWorkState(regular);
        }else if(time.after(workTime) && time.before(lateTime)){
            //大于9点  小于 12 点  是迟到
            checkRecord.setWorkState(late);
        }else{
            //算旷工
            checkRecord.setWorkState(absenteeism);
        }

       return  checkRecordDao.addCheckRecord(checkRecord);
    }

    /**
     * 判断当天是不是打卡了
     * @param accId
     * @return
     */
    @Override
    public CheckRecord queryCheckRecordIsCheck(int accId) {
        if(accId<=0){
            return null;
        }
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);
        Map<String,Object> map=getSeconds();
        map.put("empId",employee.getId());
        return checkRecordDao.queryCheckRecord(map);
    }


    /**
     * 下班打卡

     * 通过员工id  以及当天日期
     * @param accId
     * @return
     */
    @Override
    public boolean offCheckOut(int accId) throws ParseException {
        CheckRecord checkRecord = queryCheckRecordIsCheck(accId);
        //  是null  说明当天没有打卡
        if(checkRecord==null){
            return false;
        }
        //判断下班时间
        Date date=new Date();
        String off=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        checkRecord.setOffTime(off);

        String hour=simpleDateFormat.format(date);
        Date time = simpleDateFormat.parse(hour);

        if(time.before(earlyTime)){
            //早于 15:00  旷工
            checkRecord.setOffState(absenteeism);
        }else if((time.after(earlyTime) || time.equals(earlyTime)) && time.before(offTime)){
            //15:00 --18:00 之间   早退
            checkRecord.setOffState(early);
        }else{
            checkRecord.setOffState(regular);
        }
        return checkRecordDao.updateCheckRecord(checkRecord);
    }

    /**
     * 查看某员工  当月的 打卡记录
     * 参数 包括   员工id  某年   某月
     * @param accId
     * @return
     */
    @Override
    public  Map<String, Object> queryCheckRecordBY_empId_everyMonth(int accId) {
        if(accId<=0){
            return null;
        }
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);
        Date date=new Date();
        Map<String, Object> map = getMonth(date);
        map.put("empId",employee.getId());
        List<CheckRecord> checkRecords = checkRecordDao.queryCheckRecordBY_empId_everyMonth(map);

        Collections.sort(checkRecords);
        map.put("list",checkRecords);
        return map;
    }

    /**
     * 查看上月的考勤记录
     * @param accId
     * @return
     */
    @Override
    public  Map<String, Object> queryCheckRecordBY_empId_preMonth(int accId) {
        if(accId<=0){
            return null;
        }
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2,-1);
        Map<String, Object> map = getMonth(calendar.getTime());
        map.put("empId",employee.getId());
        List<CheckRecord> checkRecords = checkRecordDao.queryCheckRecordBY_empId_everyMonth(map);
        Collections.sort(checkRecords);
        map.put("list",checkRecords);
        return map;
    }

    /**
     * 得到当天的第一秒 以及最后一秒
     */
    public Map<String,Object> getSeconds(){
        Date date=new Date();
        Map<String,Object> map=new HashMap<>();
        Calendar cal = Calendar.getInstance();
        //某天的第一秒
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String start=formatter.format(cal.getTime());
        map.put("start",start);
        //某天的最后一秒
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        String end=formatter.format(cal.getTime());
        map.put("end",end);
        return map;
    }

    /**
     * 得到某月的第一天  和最后一天的格式
     * @throws ParseException
     */
    public Map<String,Object> getMonth(Date date){

        Map<String,Object> map=new HashMap<>();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        map.put("today",cal.get(5));
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //得到某月的第一天
        int first=cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), first, 0, 0, 0);
        String start = sim.format(cal.getTime());
        map.put("start",start);

        //得到某月的最后一天
        int last=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), last, 23, 59, 59);
        String end = sim.format(cal.getTime());
        map.put("end",end);
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=last;i++){
            list.add(i);
        }
        map.put("max",list);


        return map;
    }

 /*   @Test
    public void test() throws ParseException {

        Employee employee = employeeDao.queryEmployeeBy_accId(1);
        *//**
         * 判断之前有没有哪天是没有上班时间  也没有下班时间的
         *根据最近的打卡记录  有 上班时间 或者 下班时间 的
         * 如果有 记录 当天是旷工
         *//*
        CheckRecord checkRecord = checkRecordDao.queryCheckRecordLast(employee.getId());
        String wt=checkRecord.getWorkTime();
        String ot=checkRecord.getOffTime();

        //有可能 ①上班时间 下班时间都有  ②有上班时间，无下班时间   ③有可能无上班时间 有下班时间
      *//*  String newOne= wt!=null?wt:ot;
        Date time=null;
        try {
            time= new SimpleDateFormat("yyyy-MM-dd").parse(newOne);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date current=new Date();

        //①是上月的打卡时间，则需要根据当月的一号 计算
        if(time.getMonth()<current.getMonth()){
            //在判断当天是否是一号
            //如果不是一号，则需要
        }else{
            //② 是当月的打卡时间

        }*//*

    }*/

}
