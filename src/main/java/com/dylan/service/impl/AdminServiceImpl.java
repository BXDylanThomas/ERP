package com.dylan.service.impl;

import com.dylan.dao.AdminDao;
import com.dylan.model.Admin;
import com.dylan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        if(admin==null || admin.getName()==null || admin.getPassword()==null){
            return null;
        }
        return adminDao.queryAdmin(admin);
    }
}
