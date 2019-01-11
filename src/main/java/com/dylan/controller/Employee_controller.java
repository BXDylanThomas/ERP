package com.dylan.controller;

import com.dylan.model.*;
import com.dylan.service.DepartmentService;
import com.dylan.service.EmployeeService;
import com.dylan.service.PositionService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Employee_controller {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;

    //到员工个人信息
    @RequestMapping("/toemployeeinfo")
    public String toemployeeinfo(){
        return "employee/empinfo";
    }

    //到员工个人具体信息
    @RequestMapping("/toinfoemployee")
    public String toinfoemployee(HttpSession session,Model model){
        Account account= (Account) session.getAttribute("user");
        Employee employee = employeeService.queryEmployeeBy_accId(account.getId());
        model.addAttribute("employee",employee);
        return "employee/info";
    }

    /**
     * 查询所有的员工
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployee")
    public String queryAllEmployeeadmin(String current, Model model, HttpSession session){

        List<Department> dep = departmentService.queryAllDepartment();
        session.setAttribute("allDepartment",dep);

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
        return "admin/employee/employee";
    }

    /**
     * 查询某个部门的所有人
     * @param depId
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployeeByDepId")
    public String queryAllEmployeeByDepIdadmin(int depId,String current,Model model,HttpSession session){
        List<Position> positions = positionService.queryPosition(depId);
        session.setAttribute("allpositions",positions);
        //总共有多少数据
        List<Employee> all = employeeService.queryEmployeeBy_depId(depId);
        //当前页数
        int pages = PagesUtil.getPages(all.size());
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        model.addAttribute("all",all.size());

        model.addAttribute("depId",depId);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Employee> employees = employeeService.queryEmployeeBy_depId_evertPage(depId,page);
        model.addAttribute("employees",employees);
        return "admin/employee/employeedep";
    }

    /**
     * 查询某个职位的员工
     * @param posId
     * @param current
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/queryAllEmployeeByPosId")
    public String queryAllEmployeeByPosIdadmin(int posId,String current,Model model,HttpSession session){
        model.addAttribute("posId",posId);
        Position position = positionService.queryPositionBy_podId(posId);
        model.addAttribute("depId",position.getDepId());

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
        return "admin/employee/employeepos";
    }



    /**
     * 查询所有的员工
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployeeemp")
    public String queryAllEmployee(String current, Model model, HttpSession session){

        List<Department> dep = departmentService.queryAllDepartment();
        session.setAttribute("allDepartment",dep);

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
        return "employee/employee/employee";
    }

    /**
     * 查询某个部门的所有人
     * @param depId
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllEmployeeByDepIdemp")
    public String queryAllEmployeeByDepId(int depId,String current,Model model,HttpSession session){
        List<Position> positions = positionService.queryPosition(depId);
        session.setAttribute("allpositions",positions);
        //总共有多少数据
        List<Employee> all = employeeService.queryEmployeeBy_depId(depId);
        //当前页数
        int pages = PagesUtil.getPages(all.size());
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        model.addAttribute("all",all.size());

        model.addAttribute("depId",depId);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Employee> employees = employeeService.queryEmployeeBy_depId_evertPage(depId,page);
        model.addAttribute("employees",employees);
        return "employee/employee/employeedep";
    }

    /**
     * 查询某个职位的员工
     * @param posId
     * @param current
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/queryAllEmployeeByPosIdemp")
    public String queryAllEmployeeByPosId(int posId,String current,Model model,HttpSession session){
        model.addAttribute("posId",posId);
        Position position = positionService.queryPositionBy_podId(posId);
        model.addAttribute("depId",position.getDepId());

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
        return "employee/employee/employeepos";
    }

    /**
     * 员工查看 部门培训
     */
    @RequestMapping("/empQueryTrainDepartment")
    public String empQueryTrainDepartment(int accId,String current,Model model){

        //总共有多少数据
        List<TrainDepartment> all = employeeService.queryTrainDepartment(accId);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainDepartment> trainDepartments = employeeService.queryTrainDepartment_everyPage(accId,page);

        model.addAttribute("trainDepartment",trainDepartments);

        return "employee/train/traindepartment";
    }

    /**
     * 员工查看 部门培训
     */
    @RequestMapping("/empQueryTrainEmployee")
    public String empQueryTrainEmployee(int accId,String current,Model model){

        //总共有多少数据
        List<TrainEmployee> all = employeeService.queryTrainEmployee(accId);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainEmployee> trainEmployees = employeeService.queryTrainEmployee_everyPage(accId,page);

        model.addAttribute("trainEmployee",trainEmployees);

        return "employee/train/trainemployee";
    }

    /**
     * 管理员去员工管理界面
     * @param empId
     * @param model
     * @return
     */
    @RequestMapping("/admintoempmanager")
    public String admintoempmanager(int empId,Model model){
        Employee employee = employeeService.queryEmployeeBy_empId(empId);

        List<Department> dep = departmentService.queryAllDepartment();

        model.addAttribute("employee",employee);
        return "admin/employee/empmanager";
    }

    /**
     * 转正
     */
    @RequestMapping("/employeeRegular")
    public String employeeRegular(int empId){
        boolean res = employeeService.updateEmployee(empId);
        return "forward:queryAllEmployee";
    }

        /**
         * 办理离职
         */
    @RequestMapping("/employeeLeave")
    public String employeeLeave(EmployeeLeave employeeLeave){
        boolean res = employeeService.updateEmployeeLeave(employeeLeave);
        return "forward:queryAllEmployee";
    }

    /**
     * 员工换岗
     */
    @RequestMapping("/employeeChangePosition")
    public String employeeChangePosition(int empId,int posId){
        boolean res = employeeService.updateEmployeePosition(empId, posId);
        return "forward:queryAllEmployee";
    }

    /**
     * 查看离职员工
     */
    @RequestMapping("/queryemployeeleave")
    public String queryemployeeleave(String current,Model model){
        //总共有多少数据
        List<EmployeeLeave> all = employeeService.queryEmployeeLeave();
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<EmployeeLeave> employeeLeaves = employeeService.queryEmployeeLeave_everyPage(page);
        System.out.println(employeeLeaves);
        model.addAttribute("EmployeeLeave",employeeLeaves);
        return "admin/employee/leave";
    }
}
