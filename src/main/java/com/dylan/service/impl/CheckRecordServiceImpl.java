package com.dylan.service.impl;

import com.dylan.dao.CheckRecordDao;
import com.dylan.dao.EmployeeDao;
import com.dylan.dao.PrizeRecordDao;
import com.dylan.model.CheckRecord;
import com.dylan.model.Employee;
import com.dylan.model.PrizeRecord;
import com.dylan.service.CheckRecordService;
import com.dylan.util.PagesUtil;
import com.dylan.util.TimeUtil;
import oracle.sql.DATE;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    private static DecimalFormat df= new DecimalFormat("######0.0");

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
        Map<String,Object> map=TimeUtil.getMonth(date);
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

        PrizeRecord record=new PrizeRecord();
        record.setEmpId(employee.getId());
        record.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
        if(time.before(workTime) || time.equals(workTime)){
            checkRecord.setWorkState(regular);
        }else if(time.after(workTime) && time.before(lateTime)){

            //大于9点  小于 12 点  是迟到
            checkRecord.setWorkState(late);
            record.setReason("迟到");
            record.setMoney(-20.0);
            boolean res = prizeRecordDao.addPrizeRecord(record);
        }else{
            //算旷工
            checkRecord.setWorkState(absenteeism);
            record.setReason("旷工");
            record.setMoney(Double.parseDouble(df.format(-employee.getResume().getSalary().getMoney()/22)));
            boolean res = prizeRecordDao.addPrizeRecord(record);
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
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);
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

        //查找当天有没有记录]
        Map<String,Object> map=getSeconds();
        map.put("empId",employee.getId());

        PrizeRecord prizeRecord = prizeRecordDao.queryPrizeRecordBy_empId(map);

        if(time.before(earlyTime)){
            //早于 15:00  旷工
            checkRecord.setOffState(absenteeism);


            //如果prizeRecord 是 null  当天上午上班正常
            if(prizeRecord==null){
                PrizeRecord record=new PrizeRecord();
                record.setEmpId(employee.getId());
                record.setReason("旷工");
                record.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                record.setMoney(Double.parseDouble(df.format(-employee.getResume().getSalary().getMoney()/22)));
                boolean res = prizeRecordDao.addPrizeRecord(record);
            }else{
                prizeRecord.setReason("旷工");
                prizeRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                prizeRecord.setMoney(Double.parseDouble(df.format(-employee.getResume().getSalary().getMoney()/22)));
                boolean res = prizeRecordDao.updatePrizeRecord(prizeRecord);
            }
        }else if((time.after(earlyTime) || time.equals(earlyTime)) && time.before(offTime)){
            //15:00 --18:00 之间   早退
            checkRecord.setOffState(early);
            //如果上班是正常
            if(prizeRecord==null){
                PrizeRecord record=new PrizeRecord();
                record.setEmpId(employee.getId());
                record.setReason("早退");
                record.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                record.setMoney(-20.0);
            }else if(prizeRecord.getReason().contains("迟到")){
                //如果上班迟到
                prizeRecord.setReason("迟到，早退");
                prizeRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                prizeRecord.setMoney(-20.0+prizeRecord.getMoney());
                prizeRecordDao.updatePrizeRecord(prizeRecord);
            }
            //早上已经旷工了 不再计算

        }else{
            checkRecord.setOffState(regular);
        }
        return checkRecordDao.updateCheckRecord(checkRecord);
    }

    /**
     * 查看某员工  当月的 打卡记录
     * 参数 包括   员工id  某年   某月
     * @param empId
     * @return
     */
    @Override
    public  Map<String, Object> queryCheckRecordBY_empId_everyMonth(int empId) {
        if(empId<=0){
            return null;
        }
        Date date=new Date();
        Map<String, Object> map = TimeUtil.getMonth(date);
        map.put("empId",empId);
        List<CheckRecord> checkRecords = checkRecordDao.queryCheckRecordBY_empId_everyMonth(map);

        Collections.sort(checkRecords);
        map.put("list",checkRecords);
        return map;
    }

    /**
     * 查看上月的考勤记录
     * @param empId
     * @return
     */
    @Override
    public  Map<String, Object> queryCheckRecordBY_empId_preMonth(int empId) {
        if(empId<=0){
            return null;
        }
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2,-1);
        Map<String, Object> map = TimeUtil.getMonth(calendar.getTime());
        map.put("empId",empId);
        List<CheckRecord> checkRecords = checkRecordDao.queryCheckRecordBY_empId_everyMonth(map);
        Collections.sort(checkRecords);
        map.put("list",checkRecords);
        return map;
    }

    @Override
    public List<PrizeRecord> queryAllPrizeRecordBy_empId(int empId) {
        if(empId<=0){
            return null;
        }
        return prizeRecordDao.queryAllPrizeRecordBy_empId(empId);
    }

    @Override
    public List<PrizeRecord> queryAllPrizeRecordBy_empId_everyPage(int empId,int currentPage) {
        if(empId<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("empId",empId);
        map = PagesUtil.getPage(map, currentPage);
        return prizeRecordDao.queryAllPrizeRecordBy_empId_everyPage(map);
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



}
