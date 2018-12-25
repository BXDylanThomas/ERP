package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.service.AccountDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Account_controller {

    public final static String ADMIN="admin";
    public final static String EMPLOYEE="employee";
    public final static String VISITOR="visitor";

    @Autowired
    private AccountDService accountDService;

    @RequestMapping("/visitorMain")
    public String visitorMain(){
        return "visitor/main";
    }

    @RequestMapping("/login")
    public String login(Account account, HttpSession session){
        Account user = accountDService.login(account);
        if(user==null){
            return "forward:returnLogin";
        }else{
            session.setAttribute("user",user);
            if(user.getType().equals(ADMIN)){
                return "forward:returnAdmin";
            }else if(user.getType().equals(EMPLOYEE)){
                return "forward:returnEmployee";
            }else {
                return "forward:returnVisitor";
            }
        }
    }

    @RequestMapping("/returnAdmin")
    public String returnAdmin(){
        return "admin/main";
    }

    @RequestMapping("/returnEmployee")
    public String returnEmployee(){
        return "employee/main";
    }

    @RequestMapping("/returnVisitor")
    public String returnVisitor(){
        return "visitor/main";
    }

    @RequestMapping("/returnLogin")
    public String returnLogin(){
        return "login";
    }

    @RequestMapping("/returnRegister")
    public String returnRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(Account account){
        account.setType(VISITOR);
        boolean res = accountDService.register(account);
        if(res){
            return "forward:returnLogin";
        }else{
            return "forward:returnRegister";
        }
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "forward:returnLogin";
    }
}
