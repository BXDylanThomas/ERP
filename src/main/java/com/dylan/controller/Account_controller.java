package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.service.AccountDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //员工去修改密码页面
    @RequestMapping("/toemployeechangepass")
    public String toemployeechangepass(){
        return "employee/changepass";
    }

    //得到密码   为了修改密码
    @RequestMapping("/getPass")
    @ResponseBody
    public String getPass(HttpSession session){
        Account account= (Account) session.getAttribute("user");
        return account.getPassword();
    }

    @RequestMapping("/changePass")
    public String changePass(String pass,HttpSession session){
        Account account= (Account) session.getAttribute("user");
        account.setPassword(pass);
        System.out.println(account);
        boolean res = accountDService.updateAccount(account);
        if(res){
            return "forward:returnLogin";
        }else{
            return "employee/changepass";
        }
    }


    /**
     * 登录
     * @param account
     * @param session
     * @return
     */
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

    /**
     * 注册
     * @param account
     * @return
     */
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

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "forward:returnLogin";
    }
}
