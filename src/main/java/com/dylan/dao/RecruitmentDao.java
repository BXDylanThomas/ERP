package com.dylan.dao;

import com.dylan.model.Recruitment;

import java.util.List;
import java.util.Map;

/**
 * 招聘
 */
public interface RecruitmentDao {

    //添加招聘信息
    boolean addRecruitment(Recruitment recruitment);

    //删除招聘信息
    boolean deleteRecruitment(int id);



    //通过职位id   查询招聘信息数量
    List<Recruitment> queryRecruitmentBy_posId(int posId);

    //通过职位id  查询  分页
    List<Recruitment> queryRecruitmentBy_posId_everyPage(Map<String,Object> map);

    //查询所有的招聘信息 的数量
    List<Recruitment> queryAllRecruitmentBy();

    //查询所有的招聘信息 分页
    List<Recruitment> queryAllRecruitmentBy_everyPage(Map<String,Object> map);
}
