package com.dylan.service.impl;

import com.dylan.dao.RecruitmentDao;
import com.dylan.model.Recruitment;
import com.dylan.service.RecruitmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentDao recruitmentDao;

    /**
     * 添加招聘信息
     * @param recruitment
     * @return
     */
    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        if(recruitment==null || recruitment.getPosId()<=0){
            return false;
        }
        recruitment.setCreateTime(new SimpleDateFormat("yyyy-MM-dd ").format(new Date()));
        return recruitmentDao.addRecruitment(recruitment);
    }

    /**
     * 删除招聘信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteRecruitment(int id) {
        if(id<=0){
            return false;
        }
        return recruitmentDao.deleteRecruitment(id);
    }

    @Override
    public Recruitment queryRecruitmentBy_id(int id) {
        if(id<=0){
            return null;
        }
        return recruitmentDao.queryRecruitmentBy_id(id);
    }

    /**
     * 查询 所有的招聘信息   或者某职位的招聘信息
     * @param posId
     * @return
     */
    @Override
    public  List<Recruitment> queryRecruitmentBy_posId(int posId) {
        if(posId==0){
            return recruitmentDao.queryAllRecruitmentBy();
        }else{
            return recruitmentDao.queryRecruitmentBy_posId(posId);
        }
    }

    /**
     * 查询 所有的招聘信息   或者某职位的招聘信息   分页
     * @param posId
     * @param currentPage
     * @return
     */
    @Override
    public List<Recruitment> queryRecruitmentBy_posId_everyPage(int posId, int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        map = PagesUtil.getPage(map, currentPage);
        if(posId!=0){
            map.put("depId",posId);
            return recruitmentDao.queryRecruitmentBy_posId_everyPage(map);
        }else{
            return recruitmentDao.queryAllRecruitmentBy_everyPage(map);
        }
    }
}
