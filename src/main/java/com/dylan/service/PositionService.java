package com.dylan.service;

import com.dylan.model.Position;

import java.util.List;
import java.util.Map;

public interface PositionService {

    //添加职位
    boolean addPosition(Position position);

    //职位名字判重，检索所有职位
    boolean queryPositionBy_name(String name);

    //更新职位信息
    boolean updatePosition(Position position);

    //更新职位信息  state == -1  表示职位已经被删除
    boolean updatePositionBy_delete(int depId,int posId);

    //通过部门id查询所有职位
    List<Position> queryPositionBy_depId(int depId);

    //通过部门id查询所有职位  分页
    List<Position> queryPositionBy_depId_everyPage(int depId,int currentPage);

    //通过 部门id 和 职位id  查询 所有
    Position queryPositionBy_depId_posId(int depId,int posId);
}
