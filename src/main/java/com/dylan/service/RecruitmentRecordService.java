package com.dylan.service;

import com.dylan.model.Account;
import com.dylan.model.RecruitmentRecord;
import com.dylan.model.Salary;

import java.util.List;
import java.util.Map;

public interface RecruitmentRecordService {

    //添加简历投递记录表  添加的有 招聘id  简历id
    boolean addRecruitmentRecord(int recId, Account account);

    //更新 添加面试时间
    boolean updateRecruitmentRecord_time(int id, Salary salary);

    boolean sureChange(Account account,int id);

    //是否已经阅
    boolean updateRecruitmentRecord_state(int id);

    //通过id查询
    RecruitmentRecord queryRecruitmentRecordBy_id(int id);

    //查看某招聘的所有简历  招聘id
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId);

    //查看某招聘的所有简历  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(int recId,int currentPage);

    //通过 游客id  查询所有的有邀请的面试
    List<RecruitmentRecord> queryRecruitmentRecordBy_you(int accId);

    //通过 游客id  查询所有的有邀请的面试  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_you_everyPage(int accId,int currentPage);

}
