package com.dylan.service.impl;

import com.dylan.dao.PositionDao;
import com.dylan.model.Position;
import com.dylan.service.PositionService;
import com.dylan.util.PagesUtil;
import com.dylan.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    /**
     * 传进来的参数有 职位名称  职位描述  职位基本工资 所属部门id
     * 需要添加  创建时间   state =1
     * 添加职位，之前需要判断职位名称是否存在重复的
     * @param position
     * @return
     */
    @Override
    public boolean addPosition(Position position) {
        if(position==null || position.getName()==null || position.getDepid()<=0){
            return false;
        }
        //判断吃否存在重名
        if(!queryPositionBy_name(position.getName())){
            return false;
        }
        //不重名 可以添加
        position.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        position.setState(StateUtil.regular);

        return positionDao.addPosition(position);
    }

    /**
     * 检查 职位名称 是否重复
     * @param name
     * @return
     */
    @Override
    public boolean queryPositionBy_name(String name) {
        if(name==null){
            return false;
        }
         //true  说明职位名称  没有重复的  反之 false   就不能添加
        return positionDao.queryPositionBy_name(name)==null? true:false;
    }

    /**
     * 更新部门信息
     * @param position
     * @return
     */
    @Override
    public boolean updatePosition(Position position) {
        if(position==null || position.getName()==null || position.getDepid()<=0 || position.getId()<=0){
            return false;
        }
        //如果职位名称修改  则 需要检查是否 重复
        Position pos = queryPositionBy_depId_posId(position.getDepid(), position.getId());
        if(pos.getName().equals(position.getName())){
            //相同，说明没有修改，直接更新就行
            return positionDao.updatePosition(position);
        }else{
            //名字换了，需要判断  true 可以更换  false  名字已经有了  不能更换
            return queryPositionBy_name(position.getName())?positionDao.updatePosition(position):false;
        }
    }

    /**
     * 删除职位   将state = -1
     * @param depId
     * @param posId
     * @return
     */
    @Override
    public boolean updatePositionBy_delete(int depId, int posId) {
        if(depId<=0 || posId<=0){
            return false;
        }
        Map<String, Object> map = StateUtil.getMap();
        map.put("posId",posId);
        return positionDao.updatePositionBy_delete(map);
    }

    /**
     * 通过 部门id 查询所有职位  得到所有的size  为了得到总页数
     * @param depId
     * @return
     */
    @Override
    public List<Position> queryPositionBy_depId(int depId) {
        if(depId<=0){
            return null;
        }
        Map<String, Object> map = StateUtil.getMap();
        map.put("depId",depId);
        return positionDao.queryPositionBy_depId(map);
    }

    /**
     * 查询  某部门  的所有 职位  分页查询
     * @param depId
     * @param currentPage
     * @return
     */
    @Override
    public List<Position> queryPositionBy_depId_everyPage(int depId, int currentPage) {
        if(depId<=0  || currentPage<=0){
            return null;
        }
        Map<String, Object> map = StateUtil.getMap();
        map.put("depId",depId);
        map= PagesUtil.getPage(map,currentPage);
        return positionDao.queryPositionBy_depId_everypage(map);
    }

    /**
     * 查询  某部门  某职位
     * @param depId
     * @param posId
     * @return
     */
    @Override
    public Position queryPositionBy_depId_posId(int depId, int posId) {
        if(depId<=0 || posId<=0){
            return null;
        }
        Map<String,Object> map=StateUtil.getMap();
        map.put("posId",posId);
        return positionDao.queryPositionBy_depId_posId(map);
    }
}
