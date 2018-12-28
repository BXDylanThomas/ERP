package com.dylan.controller;

import com.dylan.dao.EmployeeDao;
import com.dylan.dao.TrainDao;
import com.dylan.model.Employee;
import com.dylan.model.Train;
import com.dylan.model.TrainEmployee;
import com.dylan.service.TrainEmployeeService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class TrainEmployee_controller {

    @Autowired
    private TrainEmployeeService trainEmployeeService;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 去添加员工培训 页面
     * @return
     */
    @RequestMapping("/toAddAllTrainEmployee")
    public String toAddAllTrainEmployee(){
        return "admin/train/trainemployeeadd";
    }

    /**
     * 添加培训表
     * @param train
     * @param model
     * @return
     */
    @RequestMapping("/addAllTrainEmployee")
    public String addAllTrainEmployee(Train train, Model model, HttpSession session){
        session.setAttribute("tra",train);
        List<Employee> employees = employeeDao.queryAllEmployee();
        model.addAttribute("employees",employees);
        return "admin/train/trainemployeechoice";
    }

    /**
     * 选择员工
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/addAllTrainEmployeeChoice")
    public String addAllTrainEmployeeChoice(HttpServletRequest request,HttpSession session){
        Train train= (Train) session.getAttribute("tra");
        String[] choices = request.getParameterValues("choice");
        trainEmployeeService.addTrainEmployee(choices,train);
        return "forward:queryAllTrainEmployee";
    }


    /**
     * 员工培训发布
     */
    @RequestMapping("/publicshTrainEmployee")
    public String publicshTrainEmployee(int id){
        boolean res = trainEmployeeService.updateTrainEmployee(id);
        return "forward:queryAllTrainEmployee";
    }
    /**
     * 员工培训删除
     */
    @RequestMapping("/deleteTrainEmployee")
    public String deleteTrainEmployee(int id){
        boolean res = trainEmployeeService.deleteTrainEmployee(id);
        return "forward:queryAllTrainEmployee";
    }

    /**
     * 到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updateTrainEmployee")
    public String updateTrainEmployee(int id,Model model){
        List<TrainEmployee> trainEmployees = trainEmployeeService.queryTrainEmployeeBy_tId(id);
        model.addAttribute("trains",trainEmployees.get(0).getTrain());
        model.addAttribute("trainEmployee",trainEmployees);
        return "admin/train/trainemployeeupdate";
    }
    @RequestMapping("/toupdateTrainEmployee")
    public String toupdateTrainEmployee(Train train){
        boolean res = trainDao.updateTrain(train);
        return  "forward:queryAllTrainEmployee";
    }
    /**
     * 查询所有的员工培训
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllTrainEmployee")
    public String queryAllTrainEmployee(String current, Model model){
        //总共有多少数据
        Set<Train> trains = trainEmployeeService.queryAllTrainEmployee();

        model.addAttribute("all",trains.size());
        int pages = PagesUtil.getPages(trains.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainEmployee> trainEmployees = trainEmployeeService.queryAllTrainEmployee_everyPage(page);
        Set<Train> trainSet=new TreeSet<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getId()-o2.getId();
            }
        });
        for(TrainEmployee te:trainEmployees){
            trainSet.add(te.getTrain());
        }
        model.addAttribute("trains",trainSet);
        model.addAttribute("trainEmployee",trainEmployees);
        return "admin/train/trainemployee";
    }

    /**
     * 查询所有的员工培训
     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryAllTrainEmployeeByState")
    public String queryAllTrainEmployeeByState(int state,String current, Model model){
        model.addAttribute("state",state);
        //总共有多少数据
        Set<Train> trains = trainEmployeeService.queryAllTrainEmployeeBy_state_(state);

        model.addAttribute("all",trains.size());
        int pages = PagesUtil.getPages(trains.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainEmployee> trainEmployees = trainEmployeeService.queryAllTrainEmployeeBy_state_everyPage_(page,state);
        Set<Train> trainSet=new TreeSet<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.getId()-o2.getId();
            }
        });
        for(TrainEmployee te:trainEmployees){
            trainSet.add(te.getTrain());
        }
        model.addAttribute("trains",trainSet);
        model.addAttribute("trainEmployee",trainEmployees);
        return "admin/train/trainemployeestate";
    }
}
