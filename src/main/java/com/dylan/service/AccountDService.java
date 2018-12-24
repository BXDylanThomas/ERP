package com.dylan.service;

import com.dylan.model.Account;

public interface AccountDService {

    //添加账户
    boolean register(Account account);

    //修改  密码   类型
    boolean updateAccount(Account account);

    //查询账户
    Account login(Account account);

    //通过name 查询账户  判断用户名是否重复
    boolean queryAccountBy_name(String name);

    //通过id  查询
    Account queryAccountBy_id(int id);
}
