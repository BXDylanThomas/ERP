package com.dylan.controller;

import com.dylan.model.Admin;
import com.dylan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_controller {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin){
        Admin as = adminService.login(admin);
        if(as==null){
            //用户名或者密码错误，返回中心登录
            return "admin/login";
        }else{
            //登录成功，进入后台
            return "admin/managersystem";
        }
    }
}
