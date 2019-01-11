package com.dylan.service.impl;

import com.dylan.dao.*;
import com.dylan.model.*;
import com.dylan.service.SalaryCalService;
import com.dylan.util.PagesUtil;
import com.dylan.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SalaryCalServiceImpl implements SalaryCalService {

    @Autowired
    private SalaryCalDao salaryCalDao;

    @Autowired
    private CheckRecordDao checkRecordDao;

    @Autowired
    private PrizeRecordDao prizeRecordDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SalaryReviewDao salaryReviewDao;
    /**
     * 薪资结算  上月工资
     */
    @Override
    public boolean addSalaryCal(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //查看本月有没有进行过结算
        Map<String, Object> month = TimeUtil.getMonth(new Date());
        List<SalaryCal> salaryCals = salaryCalDao.querySalaryCal(month);
        if(salaryCals!=null && !salaryCals.isEmpty()){
            return false;
        }
        String time=simpleDateFormat.format(new Date());
        boolean flag=false;
        List<Employee> employees = employeeDao.queryAllEmployee();
        for(Employee e:employees){
            SalaryCal salaryCal=new SalaryCal();
            salaryCal.setEmpId(e.getId());
            salaryCal.setTime(time);
            boolean res = salaryCalDao.addSalaryCal(salaryCal);
            if(!res){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean reviewSalary(int id,SalaryReview review) {
        if(review==null){
            return false;
        }
        Employee employee = employeeDao.queryEmployeeBy_accId(id);
        review.setEmpId(employee.getId());
        review.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        review.setState(0);
        return salaryReviewDao.addSalaryReview(review);
    }

    @Override
    public List<SalaryReview> queryAllSalaryReview() {
        return salaryReviewDao.queryAllSalaryReview();
    }

    @Override
    public List<SalaryReview> queryAllSalaryReview_everyPage(int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map = PagesUtil.getPage(map, currentPage);
        return salaryReviewDao.queryAllSalaryReview_everyPage(map);
    }


    @Override
    public List<SalaryTicket> querySalaryTicketBy_empId(int accId) throws ParseException {
        if(accId<=0){
            return null;
        }
        Employee employee = employeeDao.queryEmployeeBy_accId(accId);
        double money=employee.getResume().getSalary().getMoney();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");
        List<String> strings = salaryCalDao.queryAllSalaryCalby_time();
        List<SalaryTicket>  list=new ArrayList<>();
        for(String s:strings){
            Date date=simpleDateFormat.parse(s);
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(2,-1);

            //得到上个月的第一天和最后一天
            Map<String, Object> map = TimeUtil.getMonth(calendar.getTime());
            map.put("empId",employee.getId());
            Date end = simpleDateFormat.parse((String) map.get("end"));

            Date entry=simpleDateFormat2.parse(employee.getEntryTime());
            if(entry.after(end)){
                continue;
            }
            //查询出员工一个月的打卡情况
            //计算一个月的出勤天数  如果是旷工则不计算

            List<CheckRecord> checkRecords = checkRecordDao.queryCheckRecordBY_empId_everyMonth(map);
            int day=0;  //出勤天数
            for(CheckRecord c:checkRecords){
                if(c.getWorkState()!=4  && c.getOffState()!=4 && c.getWorkTime()!=null && c.getOffTime()!=null){
                    day+=1;
                }
            }

            //查出员工 一个月的 奖惩情况
            List<PrizeRecord> prizeRecords = prizeRecordDao.queryAllPrizeRecordBy_empId_month(map);
            double prize=0; //奖励
            double p2=0;  //迟到和早退加起来总共
            for(PrizeRecord r:prizeRecords){
                if(r.getMoney()>0){
                    prize+=r.getMoney();
                }
                if(!r.getReason().contains("旷工")){
                    p2+=r.getMoney();
                }
            }
            double publish=0; //惩罚  迟到早退 +旷工
            if(day<22){
                publish=money/22*(22-day)-p2;
                BigDecimal   p  =   new   BigDecimal(publish);
                publish=p.setScale(1,4).doubleValue();
            }

            //社保  交  5%  保留2为小数

            double ss= money*0.05;
            BigDecimal   b   =   new   BigDecimal(ss);
            double social=b.setScale(1,4).doubleValue();
            SalaryTicket salaryTicket=new SalaryTicket();
            salaryTicket.setDay(day); //出勤天数
            salaryTicket.setBase(money);  //基本工资
            //出勤20天以上才有绩效
            if(day>=20){
                salaryTicket.setPerformance(employee.getPerformance()); //绩效
            }else{
                salaryTicket.setPerformance(0.0); //绩效
            }
            //非旷工22天以上才有加班费用
            if(day>=22){
                double o = money / 22; //平均每天的
                BigDecimal bb= new BigDecimal(ss);
                double ot=bb.setScale(1,4).doubleValue();
                salaryTicket.setOt(ot*(day-22));
            }else{
                salaryTicket.setOt(0.0);
            }
            salaryTicket.setPrize(prize); //奖励
            salaryTicket.setPunish(publish);  //惩罚
            salaryTicket.setSocial(social);  //社保

            BigDecimal sm= BigDecimal.valueOf(money+salaryTicket.getPerformance()+prize-publish-social);
            double sum=sm.setScale(1,4).doubleValue();
            salaryTicket.setSum(sum);// 总计
            list.add(salaryTicket);
        }

        return list;
    }

    /**
     * 拒绝申请
     * @param id
     * @return
     */

    @Override
    public boolean salaryReviewsRefuse(int id) {
        if(id<=0) {
            return false;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("state",1);
        return salaryReviewDao.updateSalaryReview(map);
    }


    /**
     * 同意申请  并且有一条奖励记录
     */
    @Override
    public boolean sure(int id, PrizeRecord prizeRecord) {
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("state",1);
        boolean res1 = salaryReviewDao.updateSalaryReview(map);

        prizeRecord.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
       return res1 && prizeRecordDao.addPrizeRecord(prizeRecord);
    }


}
