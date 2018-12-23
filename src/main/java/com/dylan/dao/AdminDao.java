package com.dylan.dao;

import com.dylan.model.Admin;

public interface AdminDao {

    //管理员登录
    Admin queryAdmin(Admin admin);
}
