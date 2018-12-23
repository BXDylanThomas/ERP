package com.dylan.controller;

import com.dylan.model.Visitor;
import com.dylan.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class Visitor_controller  {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/visitorLogin")
    public String visitorLogin(Visitor visitor, HttpSession session){
        Visitor v = visitorService.login(visitor);
        //用户名或者密码错误，重新去登录
        if(v==null){
            return "forward:returnLogin";
        }else{
            //登录成功，保存用户扫session
            session.setAttribute("visitor",v);
            return "visitor/main";
        }
    }

    @RequestMapping("/returnLogin")
    public String returnLogin(){
        return "visitor/login";
    }

    @RequestMapping("/toRegister")
    public String returnRegister(){
        return "visitor/register";
    }
    /**
     *  通过asjax 检查用户名是否重复
     * @param name
     * @param response
     */
    @RequestMapping("/checkName")
    public void checkName(String name, HttpServletResponse response) throws IOException {
        boolean res = visitorService.queryVisitorBy_name(name);
        if(res){
            //true  用户名可以用  返回1
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    @RequestMapping("/register")
    public String register(Visitor visitor){
        boolean res = visitorService.register(visitor);
        if(res){
            //true   注册成功，去登录界面 进行登录操作
            return "forward:returnLogin";
        }else{
            //false   注册失败，重新注册
            return "forward:toRegister";
        }
    }
}
