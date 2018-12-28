package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.model.Resume;
import com.dylan.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class Resume_controller {

    @Autowired
    private ResumeService resumeService;

    /**
     * 去游客个人信息
     * @param session
     * @return
     */
    @RequestMapping("/tovisitorInfo")
    public String toVisitorInfo(HttpSession session){
        Account account = (Account) session.getAttribute("user");
        if(account==null){
            return "forward:login";
        }
        return "visitor/visitorInfo";
    }

    /**
     * 去制作简历
     * @return
     */
    @RequestMapping("/toresumemake")
    public String toresumemake(){
        return "visitor/resumemake";
    }

    /**
     * 查询个人简历
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/queryResume")
    public String queryResume(HttpSession session, Model model){
         Account account = (Account) session.getAttribute("user");

        Resume resume = resumeService.queryResumeBy_accId(account.getId());
        model.addAttribute("resume",resume);
        return "visitor/resume";
    }

    /**
     * 添加个人简历
     * @param session
     * @return
     */
    @RequestMapping("/addresumemake")
    public String addresumemake(String bir,String experience,Resume resume,HttpSession session){
        Account account = (Account) session.getAttribute("user");

        resume.setAccId(account.getId());
        resume.setBirth(bir);
        resume.setExp(experience);

        boolean res = resumeService.addResume(resume);
        return "forward:queryResume";
    }

    /**
     * 修改个人简历
     * @param resume
     * @return
     */
    @RequestMapping("/updateresumemake")
    public String updateresumemake(Resume resume){
        boolean res = resumeService.updateResume(resume);
        return "forward:queryResume";
    }

}
