package com.dylan.controller;

import com.dylan.model.Employee;
import com.dylan.service.EmployeeService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Employee_controller {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有的员工
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployee")
    public String queryAllEmployee(String current,Model model){
        //总共有多少数据
        List<Employee> all = employeeService.queryAllEmployee();

        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Employee> employees = employeeService.queryAllEmployeeBy_everyPage(page);
        model.addAttribute("employees",employees);
        return "";
    }

    /**
     * 查询某个部门的所有人
     * @param depId
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployeeByDepId")
    public String queryAllEmployeeByDepId(int depId,String current,Model model){
        //总共有多少数据
        List<Employee> all = employeeService.queryEmployeeBy_depId(depId);
        //当前页数
        int pages = PagesUtil.getPages(all.size());
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        model.addAttribute("all",all.size());

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Employee> employees = employeeService.queryEmployeeBy_depId_evertPage(depId,page);
        model.addAttribute("employees",employees);
        return "";
    }

    @RequestMapping("/queryAllEmployeeByPosId")
    public String queryAllEmployeeByPosId(int posId,String current,Model model){
        //总共有多少数据
        List<Employee> all = employeeService.queryEmployeeBy_posId(posId);

        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Employee> employees = employeeService.queryEmployeeBy_posId_everyPage(posId,page);
        model.addAttribute("employees",employees);
        return "";
    }

}
