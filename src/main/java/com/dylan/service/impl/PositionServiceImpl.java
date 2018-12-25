package com.dylan.service.impl;


import com.dylan.dao.PositionDao;
import com.dylan.model.Position;
import com.dylan.service.PositionService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    /**
     * 添加职位  之前需要判断职位名称是否重复
     * @param position
     * @return
     */
    @Override
    public boolean addPosition(Position position) {

        if(position==null || position.getName()==null || position.getName().equals("") || position.getDepId()<=0){
            return false;
        }
        if(queryPositionBy_name(position.getName())){
            position.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return positionDao.addPosition(position);
        }
        return false;
    }

    /**
     * 修改职位名称   之前也需要判断是否职位名称重复
     * 如果和之前名字相同，直接返回true
     * @param position
     * @return
     */
    @Override
    public boolean updatePosition(Position position) {
        if(position==null || position.getName()==null || position.getName().equals("") ){
            return false;
        }
        if(positionDao.queryPositionBy_name(position.getName()).equals(position.getName())){
            return true;
        }
        if(queryPositionBy_name(position.getName())){
            return positionDao.updatePosition(position);
        }
        return false;
    }

    /**
     * 删除职位
     * @param posId
     * @return
     */
    @Override
    public boolean deletePosition(int posId) {
        if(posId<=0){
            return false;
        }
        return positionDao.deletePosition(posId);
    }

    /**
     * 查询  职位名称  是否重复
     * @param name
     * @return
     */
    @Override
    public boolean queryPositionBy_name(String name) {
        if(name==null || name.equals("")){
            return false;
        }
        //true 职位名称不重复 可以添加   反之 false  不行
        return positionDao.queryPositionBy_name(name)==null?true:false;
    }

    /**
     * 通过 职位id 查询
     * @param posId
     * @return
     */
    @Override
    public Position queryPositionBy_podId(int posId) {
        if(posId<=0){
            return null;
        }
        return positionDao.queryPositionBy_podId(posId);
    }

    /**
     * 通过  部门id  查询   他里面的所有职位
     * @param depId
     * @return
     */
    @Override
    public List<Position> queryPosition(int depId) {
        if(depId<=0){
            return positionDao.queryAllPosition();
        }
        return positionDao.queryPositionBy_depId(depId);
    }

    /**
     * 职位 的 分页查询
     * @param depId
     * @param currentPage
     * @return
     */
    @Override
    public  List<Position> queryPositionBy_everyPage(int depId,int currentPage) {
        if(currentPage<=0){
            return null;
        }
        Map<String,Object> map=new HashMap<>();
        Map<String, Object> page = PagesUtil.getPage(map, currentPage);
        if(depId!=0){
            map.put("depId",depId);
            return positionDao.queryPositionBy_depId_everyPage(map);
        }else{
            return positionDao.queryAllPositionBy_everyPage(map);
        }
    }

}
