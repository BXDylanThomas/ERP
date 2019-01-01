package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.model.CheckRecord;
import com.dylan.service.CheckRecordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CheckRecord_controller {

    @Autowired
    private CheckRecordService checkRecordService;

    /**
     * 查看今天是否打卡了
     * @return
     */
    @RequestMapping("/checkIn")
     public String checkIn(Model model, HttpSession session){
        Account account= (Account) session.getAttribute("user");
        CheckRecord checkRecord = checkRecordService.queryCheckRecordIsCheck(account.getId());

        if(checkRecord==null){
            model.addAttribute("result",1);
        }else{
            if(checkRecord.getOffTime()==null){
                model.addAttribute("result",2);
            }else{
                model.addAttribute("result",3);
            }
        }
        return  "employee/main";
    }

    /**
     * 上班打卡
     */
    @RequestMapping("/goWork")
    public String goWork(HttpSession session, HttpServletResponse response) throws ParseException, IOException {
        Account account= (Account) session.getAttribute("user");
        boolean res = checkRecordService.workCheckIn(account.getId());
        return "forward:checkIn";
    }

    /**
     * 下班打卡
     */
    @RequestMapping("/goHome")
    public String goHome(HttpSession session,HttpServletResponse response) throws ParseException, IOException {
        Account account= (Account) session.getAttribute("user");
        boolean res = checkRecordService.offCheckOut(account.getId());
        return "forward:checkIn";
    }

    /**
     * 查看考勤 只能查看当月的打卡记录
     */
    @RequestMapping("/queryCheckRecord")
    public String queryCheckRecord(HttpSession session,Model model){
        Account account= (Account) session.getAttribute("user");
        Map<String, Object> map = checkRecordService.queryCheckRecordBY_empId_everyMonth(account.getId());
        model.addAttribute("checkRecords",map.get("list"));
        model.addAttribute("max",map.get("max"));
        model.addAttribute("today",map.get("today"));

        return "employee/timebook";
    }

    /**
     * 查看考勤 只能查看当月的打卡记录
     */
    @RequestMapping("/queryCheckRecordPreMonth")
    public String queryCheckRecordPreMonth(HttpSession session,Model model){
        Account account= (Account) session.getAttribute("user");
        Map<String, Object> map = checkRecordService.queryCheckRecordBY_empId_preMonth(account.getId());
        model.addAttribute("checkRecords",map.get("list"));
        model.addAttribute("max",map.get("max"));
        model.addAttribute("today",map.get("today"));

        return "employee/timebookpre";
    }

    @Test
    public void test(){
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(5));
    }
}
