package com.dylan.controller;

import com.dylan.model.Department;
import com.dylan.model.Train;
import com.dylan.model.TrainDepartment;
import com.dylan.service.DepartmentService;
import com.dylan.service.TrainDepartmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TrainDepartment_controller {

    @Autowired
    private TrainDepartmentService trainDepartmentService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/toTrainDepartmentadd")
    public String addTrainDepartment(){
        return "admin/train/traindepartmentadd";
    }

    /**
     * 查询所有的培训信息 分页
     * @param current
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/toTrainDepartment")
    public String toTrainDepartment(String current, Model model, HttpSession session){
        List<Department> departments = departmentService.queryAllDepartment();
        session.setAttribute("department",departments);
        //总共有多少数据
        List<TrainDepartment> all = trainDepartmentService.queryAllTrainDepartment();
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainDepartment> trainDepartments = trainDepartmentService.queryAllTrainDepartmentBy_everyPage(page);

        model.addAttribute("trainDepartment",trainDepartments);
        return "admin/train/traindepartment";
    }

    /**
     * 查看单个通过id
     */
    @RequestMapping("/queryDepartmentone")
    public String queryDepartmentone(int id,Model model){
        TrainDepartment trainDepartment = trainDepartmentService.queryTrainDepartmentBy_id(id);
        model.addAttribute("t",trainDepartment);
        return "admin/train/traindepartmentone";
    }

    /**
     * 查询所有的培训中已经发布的  或者未发布的
     * @return
     */
    @RequestMapping("/queryTrainDepartmentState")
    public String queryTrainDepartmentState(int state,String current,Model model){

        model.addAttribute("state",state);
        //总共有多少数据
        List<TrainDepartment> all = trainDepartmentService.queryAllTrainDepartment_send(state);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainDepartment> trainDepartments = trainDepartmentService.queryAllTrainDepartment_send_everyPage(state,page);

        model.addAttribute("trainDepartment",trainDepartments);
        return "admin/train/traindepartmentsend";
    }

    /**
     * 查询部门的所有培训
     * @param depId

     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryTrainDepartmentDEP")
    public String queryTrainDepartmentDEP(int depId,String current,Model model){

        model.addAttribute("depId",depId);
        //总共有多少数据
        List<TrainDepartment> all = trainDepartmentService.queryAllTrainDepartmentBy_depId(depId);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainDepartment> trainDepartments = trainDepartmentService.queryAllTrainDepartmentBy_depId_everyPage(depId,page);

        model.addAttribute("trainDepartment",trainDepartments);
        return "admin/train/traindepartmentalldep";
    }

    /**
     * 查询部门的所有培训
     * @param depId

     * @param current
     * @param model
     * @return
     */
    @RequestMapping("/queryTrainDepartmentDEPState")
    public String queryTrainDepartmentDEPState(int depId,int state,String current,Model model){

        model.addAttribute("depId",depId);
        model.addAttribute("state",state);
        //总共有多少数据
        List<TrainDepartment> all = trainDepartmentService.queryAllTrainDepartmentBy_depId_send(depId,state);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<TrainDepartment> trainDepartments = trainDepartmentService.queryAllTrainDepartmentBy_depId_send_everyPage(depId,state,page);

        model.addAttribute("trainDepartment",trainDepartments);
        return "admin/train/traindepartmentalldepsend";
    }
    /**
     * 添加培训信息
     * @param depId
     * @param train
     * @return
     */
    @RequestMapping("/addtraindepartment")
    public String addtraindepartment(int depId,Train train){
        boolean res = trainDepartmentService.addTrainDepartment(train, depId);
        return "forward:toTrainDepartment";
    }


    @RequestMapping("/toupdatetraindepartment")
    public String toupdatetraindepartment(int id,Model model){
        TrainDepartment trainDepartment = trainDepartmentService.queryTrainDepartmentBy_id(id);
        model.addAttribute("trainDepartment",trainDepartment);
        return "admin/train/traindepartmentupdate";
    }
    /**
     * 修改培训信息
     * @param train
     * @return
     */
    @RequestMapping("/updatetraindepartment")
    public String updatetraindepartment(int depId,int tdId,Train train){

     boolean res = trainDepartmentService.updateDepartmentby_depId(tdId,depId,train);
        return "forward:toTrainDepartment";
    }

    /**
     * 发布培训信息
     * @param id
     * @return
     */
    @RequestMapping("/publishtraindepartment")
    public String publishtraindepartment(int id){
        boolean res = trainDepartmentService.updateDepartment(id);
        return "forward:toTrainDepartment";
    }

    /**
     * 删除培训信息
     * @param id
     * @return
     */
    @RequestMapping("/deletetraindepartment")
    public String deletetraindepartment(int id){
        boolean res = trainDepartmentService.deleteDeTrainDepartment(id);
        return "forward:toTrainDepartment";
    }
}
