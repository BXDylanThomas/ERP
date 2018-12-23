package com.dylan.controller;

import com.dylan.model.Department;
import com.dylan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Department_controller {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/addDepartment")
    public String addDepartment(Department department, Model model){
        boolean res = departmentService.addDepartment(department);
        model.addAttribute("res",res);
        if(res){
            List<Department> departments = departmentService.queryAllDepartment();
            model.addAttribute("departments",departments);
        }
        return "admin/managersystem";
    }

    @RequestMapping("/queryDepartment")
    public String queryDepartment( Model model){

        List<Department> departments = departmentService.queryAllDepartment();
        model.addAttribute("departments",departments);
        return "admin/managersystem";
    }
}
