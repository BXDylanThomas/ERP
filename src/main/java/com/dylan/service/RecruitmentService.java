package com.dylan.service;

import com.dylan.model.Recruitment;

import java.util.List;

public interface RecruitmentService {

    //添加招聘信息
    boolean addRecruitment(Recruitment recruitment);

    //删除招聘信息
    boolean deleteRecruitment(int id);

    //通过id查询某个具体的
    Recruitment queryRecruitmentBy_id(int id );

    //通过职位id   查询招聘信息数量
    List<Recruitment> queryRecruitmentBy_posId(int posId);

    //通过职位id  查询  分页
    List<Recruitment> queryRecruitmentBy_posId_everyPage(int posId,int currentPage);

}
