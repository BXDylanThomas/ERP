package com.dylan.controller;

import com.dylan.model.Department;
import com.dylan.service.DepartmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class Department_controller {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @RequestMapping("/addDepartment")
    public void addDepartment(Department department,HttpServletResponse response) throws IOException {
        System.out.println(department);
        boolean res = departmentService.addDepartment(department);
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    /**
     * 查询所有部门
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryDepartment")
    public String queryDepartment(String current, Model model, HttpSession session){

        //总共有多少数据
        List<Department> all = departmentService.queryAllDepartment();
        session.setAttribute("allDepartment",all);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Department> departments = departmentService.queryAllDepartmentBy_everypage(page);
        model.addAttribute("department",departments);
        return "admin/department";
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @RequestMapping("/deleteDepartment")
    public void deleteDepartment(Integer id,HttpServletResponse response) throws IOException {
        boolean res = departmentService.deleteDepartment(id);
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    /**
     * 更新部门信息  名字

     * @return
     */
    @RequestMapping("/updateDepartment")
    public void updateDepartment(Department department,HttpServletResponse response) throws IOException {
        boolean res = departmentService.updateDepartment(department);
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

}
