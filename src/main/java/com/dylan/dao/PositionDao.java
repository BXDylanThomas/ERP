package com.dylan.dao;

import com.dylan.model.Position;

import java.util.List;
import java.util.Map;

public interface PositionDao {

    //添加职位
    boolean addPosition(Position position);

    //职位名字判重，检索所有职位
    Position queryPositionBy_name(String name);

    //更新职位信息
    boolean updatePosition(Position position);

    //更新职位信息  state == -1  表示职位已经被删除
    boolean updatePositionBy_delete(Map<String,Object> map);

    //通过部门id查询所有职位
    List<Position> queryPositionBy_depId(Map<String,Object> map);

    //通过部门id查询所有职位  分页
    List<Position> queryPositionBy_depId_everypage(Map<String,Object> map);

    //通过 部门id 和 职位id  查询
    Position queryPositionBy_depId_posId(Map<String,Object> map);
}
