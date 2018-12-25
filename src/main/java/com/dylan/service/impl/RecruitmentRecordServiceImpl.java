package com.dylan.service.impl;

import com.dylan.dao.AccountDao;
import com.dylan.dao.RecruitmentDao;
import com.dylan.dao.RecruitmentRecordDao;
import com.dylan.dao.ResumeDao;
import com.dylan.model.Account;
import com.dylan.model.Recruitment;
import com.dylan.model.RecruitmentRecord;
import com.dylan.model.Resume;
import com.dylan.service.RecruitmentRecordService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RecruitmentRecordServiceImpl implements RecruitmentRecordService {
    public final static int UNREAD=0;
    public final static int HASREAD=1;
    public final static String EMPLOYEE="employee";

    @Autowired
    private RecruitmentRecordDao recruitmentRecordDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ResumeDao resumeDao;

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
     * 如果通知面试 ，默认表示已经录用  修改账号 状态为 员工
     * 面试时间设置是  确认的第二天
     * @return
     */
    @Override
    public boolean updateRecruitmentRecord_time(int id,int accId) {
        if(id<=0|| accId<=0){
            return false;
        }
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();
        System.out.println(date);

        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("state",HASREAD);
        map.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

        boolean res1 = recruitmentRecordDao.updateRecruitmentRecord_time(map);

        //修改游客账号状态 变成 员工
        Account account = accountDao.queryAccountBy_id(accId);
        account.setType(EMPLOYEE);
        boolean res2 = accountDao.updateAccount(account);
        return res1 && res2;
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

    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId) {
        if(recId<=0){
            return null;
        }
        return recruitmentRecordDao.queryRecruitmentRecordBy_accId(recId);
    }

    @Override
    public List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(int recId, int currentPage) {
        if(recId<=0 || currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("recId",recId);
        Map<String, Object> page = PagesUtil.getPage(map, currentPage);
        return recruitmentRecordDao.queryRecruitmentRecordBy_accId_everyPae(map);
    }
}
