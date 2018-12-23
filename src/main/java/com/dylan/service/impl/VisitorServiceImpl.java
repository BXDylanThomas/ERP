package com.dylan.service.impl;

import com.dylan.dao.VisitorDao;
import com.dylan.model.Visitor;
import com.dylan.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    /**
     * 游客注册
     * 先检查用户名是否存在
     * @param visitor
     * @return
     */

    @Override
    public boolean register(Visitor visitor) {
        if(visitor==null || visitor.getName()==null || visitor.getPassword()==null){
            return false;
        }
        return queryVisitorBy_name(visitor.getName()) && visitorDao.addVisitor(visitor);
    }

    /**
     * visitor等于null
     * 说明不存在该用户名  可以注册  false 相反
     * @param name
     * @return
     */
    @Override
    public boolean queryVisitorBy_name(String name) {
        if(name==null){
            return false;
        }
        Visitor visitor = visitorDao.queryVisitorBy_name(name);

        return visitor==null?true:false;
    }

    /**
     *已经拥有账户，进行登录
     * @param visitor
     * @return
     */
    @Override
    public Visitor login(Visitor visitor) {
        if(visitor==null || visitor.getName()==null || visitor.getPassword()==null){
            return null;
        }
        return visitorDao.queryVisitor(visitor);
    }
}
