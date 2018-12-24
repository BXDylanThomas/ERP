package com.dylan.service.impl;

import com.dylan.dao.AccountDao;
import com.dylan.model.Account;
import com.dylan.service.AccountDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDServiceImpl implements AccountDService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 游客注册  之前需要检查用户名是否相同
     * @param account
     * @return
     */
    @Override
    public boolean register(Account account) {
        if(account==null || account.getName()==null || account.getPassword()==null){
            return false;
        }
        if(queryAccountBy_name(account.getName())){
            return accountDao.addAccount(account);
        }
        return false;
    }

    /**
     * 更新用户的密码 或者类型
     * @param account
     * @return
     */
    @Override
    public boolean updateAccount(Account account) {
        if(account==null || account.getName()==null || account.getPassword()==null){
            return false;
        }
        Account acc = queryAccountBy_id(account.getId());
        if(account.getPassword()!=null){
            acc.setPassword(account.getPassword());
        }
        if(account.getType()!=null){
            acc.setType(account.getType());
        }
        return accountDao.updateAccount(acc);
    }

    /**
     * 登录
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        if(account==null || account.getName()==null || account.getPassword()==null){
            return null;
        }
        return accountDao.queryAccount(account);
    }

    /**
     * 检查名字是否重复
     * @param name
     * @return
     */
    @Override
    public boolean queryAccountBy_name(String name) {
        if(name==null || name.equals("")){
            return false;
        }
        //true   说明名字不重复 可以添加   false  则相反
        return accountDao.queryAccountBy_name(name)==null?true:false;
    }

    /**
     * 通过id  查询
     * @param id
     * @return
     */
    @Override
    public Account queryAccountBy_id(int id) {
        if(id<=0){
            return null;
        }
        return accountDao.queryAccountBy_id(id);
    }
}
