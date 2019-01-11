package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.model.PrizeRecord;
import com.dylan.model.SalaryReview;
import com.dylan.model.SalaryTicket;
import com.dylan.service.SalaryCalService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class Salary_controller {

    @Autowired
    private SalaryCalService salaryCalService;

    /**
     * 到薪资结算页面
     */
    @RequestMapping("/salaryCal")
    public String salaryCal(){return "admin/salary/salary";}

    /**
     * 结算上月工资
     */
    @RequestMapping("toSalarycal")
    public void toSalarycal(HttpServletResponse response) throws ParseException, IOException {
        boolean res = salaryCalService.addSalaryCal();
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    /**
     * 查看工资条
     * @param session
     * @param model
     * @return
     * @throws ParseException
     */
    @RequestMapping("toSalary")
    public String toSalary(HttpSession session, Model model) throws ParseException {
        Account account= (Account) session.getAttribute("user");
        List<SalaryTicket> salaryTickets = salaryCalService.querySalaryTicketBy_empId(account.getId());
        model.addAttribute("ticket",salaryTickets);
        return "employee/salary/salary";
    }

    /**
     * 对工资提起复议
     */
    @RequestMapping("toReviewSalary")
    public String toReviewSalary(HttpSession session, Model model) throws ParseException {
        return "employee/salary/reviewsalary";
    }

    /**
     * 工资复议提交
     */
    @RequestMapping("reviewSalary")
    public String reviewSalary(HttpSession session,SalaryReview salaryReview, Model model) throws ParseException {
        Account account= (Account) session.getAttribute("user");
        boolean res = salaryCalService.reviewSalary(account.getId(),salaryReview);
        return "forward:toSalary";
    }
    /**
     * 管理员查看所有的薪资复议
     */
    @RequestMapping("queryAllReviewSalary")
    public String reviewSalary(String current, Model model) throws ParseException {
        List<SalaryReview> all = salaryCalService.queryAllSalaryReview();

        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<SalaryReview> salaryReviews = salaryCalService.queryAllSalaryReview_everyPage(page);

        model.addAttribute("salaryReviews",salaryReviews);
        return "admin/salary/salaryreview";
    }

    /**
     * 拒绝薪资复议申请
     */
    @RequestMapping("/salaryReviewsRefuse")
    public String salaryReviewsRefuse(int id){
        boolean res=salaryCalService.salaryReviewsRefuse(id);
        return "forward:queryAllReviewSalary";
    }
    /***
     * 同意复议申请  生成奖励记录
     */
    @RequestMapping("/salaryReviewsAgree")
    public String salaryReviewsAgree(int id,int empId,Model model){
        model.addAttribute("id",id);
        model.addAttribute("empId",empId);
        return "admin/salary/salaryagree";
    }
    /**
     * 确认
     */
    @RequestMapping("/salaryReviewSure")
    public String salaryReviewSure(int id,PrizeRecord prizeRecord){
        System.out.println(prizeRecord);
        boolean res=salaryCalService.sure(id,prizeRecord);
        return "forward:queryAllReviewSalary";
    }
}
