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

    //通过id查询
    RecruitmentRecord queryRecruitmentRecordBy_id(int id);

    //查看某招聘的所有简历  招聘id
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId(int recId);

    //查看某招聘的所有简历  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_accId_everyPae(Map<String,Object> map);


    //通过 游客id  查询所有的有邀请的面试
    List<RecruitmentRecord> queryRecruitmentRecordBy_you(int accId);

    //通过 游客id  查询所有的有邀请的面试  分页
    List<RecruitmentRecord> queryRecruitmentRecordBy_you_everyPage(Map<String,Object> map);

}
