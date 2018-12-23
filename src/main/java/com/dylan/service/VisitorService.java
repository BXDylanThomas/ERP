package com.dylan.service;

import com.dylan.model.Visitor;

public interface VisitorService {

    //注册
     boolean register(Visitor visitor);

     //查询用户名是否重复
    boolean queryVisitorBy_name(String name);

    //登录
    Visitor login(Visitor visitor);

}
