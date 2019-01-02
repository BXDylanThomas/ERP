package com.dylan.controller;

import com.dylan.dao.EmployeeDao;
import com.dylan.model.*;
import com.dylan.service.CheckRecordService;
import com.dylan.service.EmployeeService;
import com.dylan.util.PagesUtil;
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
    @Autowired
    private EmployeeService employeeService;

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
        Employee employee = employeeService.queryEmployeeBy_accId(account.getId());
        Map<String, Object> map = checkRecordService.queryCheckRecordBY_empId_everyMonth(employee.getId());
        model.addAttribute("checkRecords",map.get("list"));
        model.addAttribute("max",map.get("max"));
        model.addAttribute("today",map.get("today"));

        return "employee/timebook";
    }

    /**
     * 查看考勤 只能查看上月的打卡记录
     */
    @RequestMapping("/queryCheckRecordPreMonth")
    public String queryCheckRecordPreMonth(HttpSession session,Model model){
        Account account= (Account) session.getAttribute("user");
        Employee employee = employeeService.queryEmployeeBy_accId(account.getId());
        Map<String, Object> map = checkRecordService.queryCheckRecordBY_empId_preMonth(employee.getId());
        model.addAttribute("checkRecords",map.get("list"));
        model.addAttribute("max",map.get("max"));
        model.addAttribute("today",map.get("today"));

        return "employee/timebookpre";
    }

    /**
     * 查看某员工的上月考勤
     */
    @RequestMapping("/queryCheckRecordEmpId")
    public String queryCheckRecordEmpId(int empId,Model model){
        Map<String, Object> map = checkRecordService.queryCheckRecordBY_empId_preMonth(empId);
        model.addAttribute("checkRecords",map.get("list"));
        model.addAttribute("max",map.get("max"));
        model.addAttribute("today",map.get("today"));
        return "admin/employee/employeecheckrecord";
    }

    /**
     * 查看某员工历史奖惩
     */
    @RequestMapping("/queryPrizeRecordEmpId")
    public String queryPrizeRecordEmpId(Model model,HttpSession session,String current){
        Account account= (Account) session.getAttribute("user");
        Employee employee = employeeService.queryEmployeeBy_accId(account.getId());
        List<PrizeRecord> all = checkRecordService.queryAllPrizeRecordBy_empId(employee.getId());

        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<PrizeRecord> prizeRecords = checkRecordService.queryAllPrizeRecordBy_empId_everyPage(employee.getId(), page);
        model.addAttribute("prizeRecords",prizeRecords);
        return "employee/prizerecord";
    }

    /**
     * 管理员查看员工奖惩
     */
    @RequestMapping("/queryAdminPrizeRecordEmpId")
    public String queryAdminPrizeRecordEmpId(int empId,Model model,HttpSession session,String current){

        List<PrizeRecord> all = checkRecordService.queryAllPrizeRecordBy_empId(empId);

        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<PrizeRecord> prizeRecords = checkRecordService.queryAllPrizeRecordBy_empId_everyPage(empId, page);
        model.addAttribute("prizeRecords",prizeRecords);
        return "admin/employee/employeeprizerecord";
    }

}
