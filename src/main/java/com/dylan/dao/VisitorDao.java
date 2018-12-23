package com.dylan.dao;

import com.dylan.model.Visitor;

public interface VisitorDao {

    //注册
     boolean addVisitor(Visitor visitor);

     //查询用户名是否重复
    Visitor queryVisitorBy_name(String name);
    //登录
    Visitor queryVisitor(Visitor visitor);

}
