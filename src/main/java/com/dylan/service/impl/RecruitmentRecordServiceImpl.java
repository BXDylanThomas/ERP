package com.dylan.service.impl;

import com.dylan.dao.*;
import com.dylan.model.*;
import com.dylan.service.RecruitmentRecordService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RecruitmentRecordServiceImpl implements RecruitmentRecordService {
    public final static int UNREAD=0;
    public final static int HASREAD=1;
    public final static int WATCH=3;
    public final static String EMPLOYEE="employee";


    @Autowired
    private RecruitmentRecordDao recruitmentRecordDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SalaryDao salaryDao;

    /**
     * 添加简历投递记录表  添加的有 招聘id  简历id
     * 状态默认设置是 未读  state = 0
     *投递的时候还要判断是否已经投递，如果已经投递不能再投了
     * @return
     */
    @Override
    public boolean addRecruitmentRecord(int recId, Account account) {
        if(recId<=0 || account==null){
            return false;
        }
        Resume resume = resumeDao.queryResumeBy_accId(account.getId());

        //判断是否已经投递了
        List<RecruitmentRecord> recruitmentRecords = recruitmentRecordDao.queryRecruitmentRecordBy_accId(recId);

        for(RecruitmentRecord r:recruitmentRecords){
            if(r.getResId()==resume.getId()){
                return false;
            }
        }

        RecruitmentRecord recruitmentRecord=new RecruitmentRecord();
        recruitmentRecord.setRecId(recId);

        recruitmentRecord.setResId(resume.getId());
        recruitmentRecord.setState(UNREAD);
        return recruitmentRecordDao.addRecruitmentRecord(recruitmentRecord);
    }

    /**
     * 如果通知面试
     * 面试时间设置是  确认的第二天
     * @return
     */
    @Override
    public boolean updateRecruitmentRecord_time(int id,Salary salary) {
        if(id<=0){
            return false;
        }
        //如果已经有面试时间返回
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();

        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("state",HASREAD);
        map.put("time",new SimpleDateFormat("yyyy-MM-dd").format(date));

        //添加基本薪资
        boolean res = salaryDao.addSalary(salary);
        System.out.println(res);
        return recruitmentRecordDao.updateRecruitmentRecord_time(map) && res;
    }

    /**确认成为员工
     *
     * @param account
     * @return
     */
    @Override
    public boolean sureChange(Account account,int id) {
        if(account==null){
            return false;
        }


        account.setType(EMPLOYEE);
        boolean res = accountDao.updateAccount(account);
        Resume resume = resumeDao.queryResumeBy_accId(account.getId());
        RecruitmentRecord recruitmentRecord = recruitmentRecordDao.queryRecruitmentRecordBy_id(id);
        Employee  employee=new Employee();
        //账号
        employee.setAccId(account.getId());
        //设置简历id
        employee.setResId(resume.getId());
        //职位id
        employee.setPosId(recruitmentRecord.getRecruitment().getPositions().getId());
        //薪资id
        Salary salary = salaryDao.querySalaryBy_resId(resume.getId());

        employee.setSalId(salary.getId());
        //入职时间
        employee.setEntryTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //计算绩效 基本的10%  保留2位
        DecimalFormat df2 = new DecimalFormat("#.00");
        double money=salary.getMoney()*0.1;
        money= Double.parseDouble(df2.format(money));
        employee.setPerformance(money);

        //添加员工试用期
        employee.setEmpState(WATCH);
        //判断之前是不是在公司干过
        Employee em = employeeDao.queryEmployeeBy_accId(account.getId());
        if(em!=null){
            employee.setId(em.getId());

            return res && employeeDao.updateEmployeenew(employee);
        }
        //添加员工
        boolean res2 = employeeDao.addEmployee(employee);
        return res && res2;
    }

    /**
     * 已阅表示  没有面试时间   表示没有看上，不被录用
     * @return
     */
    @Override
    public boolean updateRecruitmentRecord_state(int id) {
        if(id<=0){
            return false;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("state",HASREAD);
        return recruitmentRecordDao.updateRecruitmentRecord_state(map);
    }

    /**
     *  //通过id查询
     * @param id
     * @return
     */
    @Override
    public RecruitmentRecord queryRecruitmentRecordBy_id(int id) {
        if(id<=0){
            return null;
        }
        return recruitmentRecordDao.queryRecruitmentRecordBy_id(id);
    }

    /**
     * 通过职位id 查询  所有
     * @param recId
     * @return
     */
    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId) {
        if(recId<=0){
            return null;
        }
        return recruitmentRecordDao.queryRecruitmentRecordBy_accId(recId);
    }
    /**
     * 通过职位id 查询  分页
     * @param recId
     * @return
     */
    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(int recId, int currentPage) {
        if(recId<=0 || currentPage<=0){
            return null;
        }

        Map<String,Object> map=new HashMap<>();
        map.put("recId",recId);
        Map<String, Object> page = PagesUtil.getPage(map, currentPage);

        List<RecruitmentRecord> recruitmentRecords = recruitmentRecordDao.queryRecruitmentRecordBy_accId_everyPae(map);
        return recruitmentRecords;
    }

    /**
     * //通过 游客id  查询所有的有邀请的面试
     * @param accId
     * @return
     */
    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_you(int accId) {
        if(accId<=0){
            return null;
        }
        return recruitmentRecordDao.queryRecruitmentRecordBy_you(accId);
    }

    /**
     * //通过 游客id  查询所有的有邀请的面试  分页
     * @param accId
     * @param currentPage
     * @return
     */
    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_you_everyPage(int accId, int currentPage) {
        if(accId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("accId",accId);
         map = PagesUtil.getPage(map, currentPage);
        return recruitmentRecordDao.queryRecruitmentRecordBy_you_everyPage(map);
    }
}
