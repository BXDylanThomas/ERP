package com.dylan.service;

import com.dylan.model.Account;
import com.dylan.model.RecruitmentRecord;

import java.util.List;
import java.util.Map;

public interface RecruitmentRecordService {

    //添加简历投递记录表  添加的有 招聘id  简历id
    boolean addRecruitmentRecord(int recId, Account account);

    //更新 添加面试时间
    boolean updateRecruitmentRecord_time(int id,int accId);

    //是否已经阅
    boolean updateRecruitmentRecord_state(int id);

    //查看某招聘的所有简历  招聘id
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId);

    //查看某招聘的所有简历  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(int recId,int currentPage);
}
