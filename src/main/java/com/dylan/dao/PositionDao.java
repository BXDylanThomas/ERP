package com.dylan.dao;

import com.dylan.model.Position;

import java.util.List;
import java.util.Map;

public interface PositionDao {

    //添加职位
    boolean addPosition(Position position);

    //更新职位名称
    boolean updatePosition(Position position);

    //删除职位
    boolean deletePosition(int posId);

    //通过名字 查询职位  判断是否重复
    Position queryPositionBy_name(Map<String,Object> map);

    //通过 职位 id  查询职位
    Position queryPositionBy_podId(int posId);

    //通过部门id  查询  某部门的   所有职位
    List<Position> queryAllPosition();

    //通过部门id  查询  某部门的   所有职位  分页
    List<Position> queryAllPositionBy_everyPage(Map<String,Object> map);



    //通过部门id  查询  某部门的   所有职位
    List<Position> queryPositionBy_depId(int depId);

    //通过部门id  查询  某部门的   所有职位  分页
    List<Position> queryPositionBy_depId_everyPage(Map<String,Object> map);

}
