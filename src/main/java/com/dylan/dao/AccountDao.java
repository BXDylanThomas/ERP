package com.dylan.dao;

import com.dylan.model.Account;
import com.dylan.model.Resume;

public interface AccountDao {

    //添加账户
    boolean addAccount(Account account);

    //修改  密码   类型
    boolean updateAccount(Account account);

    //查询账户
    Account queryAccount(Account account);

    //通过name 查询账户  判断用户名是否重复
    Account queryAccountBy_name(String name);

    //通过id  查询
    Account queryAccountBy_id(int id);

    //通过员工id查账号
    Account queryAccountBy_empId(int empId);
}
