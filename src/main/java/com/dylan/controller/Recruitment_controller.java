package com.dylan.controller;

import com.dylan.model.Position;
import com.dylan.model.Recruitment;
import com.dylan.service.PositionService;
import com.dylan.service.RecruitmentService;
import com.dylan.util.PagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class Recruitment_controller {

    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private PositionService positionService;

    /***
     * 添加招聘信息
     * @param recruitment
     * @return
     */
    @RequestMapping("/addRecruitment")
    public String addRecruitment(Recruitment recruitment){
        recruitment.setContent(recruitment.getContent().trim());
        boolean res = recruitmentService.addRecruitment(recruitment);
       return "forward:queryAllRecruitment";
    }

    @RequestMapping("/toRecruitment")
    public String toRecruitment(HttpSession session){
        List<Position> positions = positionService.queryPosition(0);
        session.setAttribute("positions",positions);
        return "admin/recruitmentadd";
    }

    @RequestMapping("/deleteRecruitment")
    public String deleteRecruitment(Integer id){
        boolean res = recruitmentService.deleteRecruitment(id);
        return "forward:queryAllRecruitment";
    }

    @RequestMapping("/queryRe")
    @ResponseBody
    public List<Position> queryRe(Integer depId) throws IOException {
        List<Position> positions = positionService.queryPosition(depId);
        return positions;
    }
    /**
     * 管理员 查询所有的招聘信息
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
     * 员工查看招聘
     */
    @RequestMapping("/visitorqueryAllRecruitment")
    public String visitorqueryAllRecruitment(String current, Model model){
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
        return "visitor/recruitment";
    }

    /**
     * 查看某个具体的招聘信息
     */
    @RequestMapping("/visitorqueryOneRecruitment")
    public String visitorqueryOneRecruitment(int id ,Model model){
        Recruitment recruitment = recruitmentService.queryRecruitmentBy_id(id);
        model.addAttribute("recruitment",recruitment);
        return "visitor/recruitmentone";
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
