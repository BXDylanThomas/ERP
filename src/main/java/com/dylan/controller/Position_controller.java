package com.dylan.controller;

import com.dylan.dao.EmployeeDao;
import com.dylan.model.Department;
import com.dylan.model.Employee;
import com.dylan.model.Position;
import com.dylan.service.DepartmentService;
import com.dylan.service.PositionService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class Position_controller {

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/addPosition")
    public void addPosition(Position position, HttpServletResponse response) throws IOException {

        boolean res = positionService.addPosition(position);
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }

    /**
     * 查询某个部门的
     * @param depId
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryPosition")
    public String queryPosition(Integer depId, String current, Model model, HttpSession session){

        model.addAttribute("depId",depId);
        List<Department> all = departmentService.queryAllDepartment();
        session.setAttribute("allDepartment",all);

        //总共有多少数据
        List<Position> positions = positionService.queryPosition(depId);

        model.addAttribute("all",positions.size());
        int pages = PagesUtil.getPages(positions.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Position> pos = positionService.queryPositionBy_everyPage(depId,page);
        model.addAttribute("position",pos);
        return "admin/depPosition";
    }

    /**
     * 查询所有的
     * @return
     */
    @RequestMapping("/queryALlPosition")
    public String queryAllPosition(String current, Model model, HttpSession session){

        List<Department> all = departmentService.queryAllDepartment();
        session.setAttribute("allDepartment",all);

        //总共有多少数据
        List<Position> positions = positionService.queryPosition(0);

        model.addAttribute("all",positions.size());
        int pages = PagesUtil.getPages(positions.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Position> pos = positionService.queryPositionBy_everyPage(0,page);
        model.addAttribute("position",pos);
        return "admin/position";
    }

    @RequestMapping("/deletePosition")
    public void deletePosition(Integer id,HttpServletResponse response) throws IOException {
        List<Employee> employees = employeeDao.queryEmployeeBy_posId(id);

        if(employees!=null && !employees.isEmpty()){

            response.getWriter().write("0");
        }else{
             boolean res = positionService.deletePosition(id);

            response.getWriter().write("1");
        }

    }

    @RequestMapping("/updatePosition")
    public void updatePosition(Position position, HttpServletResponse response) throws IOException {

        boolean res = positionService.updatePosition(position);
        if(res){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
    }
}
