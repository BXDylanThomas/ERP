package com.dylan.controller;

import com.dylan.model.Recruitment;
import com.dylan.service.RecruitmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Recruitment_controller {

    @Autowired
    private RecruitmentService recruitmentService;

    /***
     * 添加招聘信息
     * @param recruitment
     * @return
     */
    @RequestMapping("/addRecruitment")
    public String addRecruitment(Recruitment recruitment){
        boolean res = recruitmentService.addRecruitment(recruitment);
        if(res){
            return "";
        }else{
            return "";
        }
    }
    @RequestMapping("/deleteRecruitment")
    public String deleteRecruitment(Integer id){
        boolean res = recruitmentService.deleteRecruitment(id);
        return "forward:queryAllRecruitment";
    }

    /**
     * 查询所有的招聘信息
     * @param current
     * @return
     */
    @RequestMapping("/queryAllRecruitment")
    public String queryAllRecruitment(String current, Model model){
        //总共有多少数据
        List<Recruitment> rec = recruitmentService.queryRecruitmentBy_posId(0);

        model.addAttribute("all",rec.size());
        int pages = PagesUtil.getPages(rec.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Recruitment> recruitment = recruitmentService.queryRecruitmentBy_posId_everyPage(0,page);

        model.addAttribute("recruitment",recruitment);
        return "admin/recruitment";

    }

    /**
     * 查询某个部门的招聘信息
     * @param posId
     * @param current
     * @return
     */
    @RequestMapping("/queryRecruitmentby_posId")
    public String queryRecruitmentby_posId(Integer posId,String current,Model model){
        //总共有多少数据
        List<Recruitment> rec = recruitmentService.queryRecruitmentBy_posId(posId);

        model.addAttribute("all",rec.size());
        int pages = PagesUtil.getPages(rec.size());

        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);

        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<Recruitment> recruitment = recruitmentService.queryRecruitmentBy_posId_everyPage(posId,page);

        model.addAttribute("recruitment",recruitment);
        return "admin/recruitment";
    }
}
