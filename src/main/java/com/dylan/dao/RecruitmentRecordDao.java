package com.dylan.dao;

import com.dylan.model.RecruitmentRecord;

import java.util.List;
import java.util.Map;

public interface RecruitmentRecordDao {

    //添加简历投递记录表  添加的有 招聘id  简历id
    boolean addRecruitmentRecord(RecruitmentRecord recruitmentRecord);

    //更新 添加面试时间
    boolean updateRecruitmentRecord_time(Map<String,Object> map);

    //是否已经阅
    boolean updateRecruitmentRecord_state(Map<String,Object> map);

    //查看某招聘的所有简历  招聘id
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId);

    //查看某招聘的所有简历  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(Map<String,Object> map);
}
