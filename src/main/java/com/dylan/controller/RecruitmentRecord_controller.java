package com.dylan.controller;

import com.dylan.model.Account;
import com.dylan.model.RecruitmentRecord;
import com.dylan.service.RecruitmentRecordService;
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
public class RecruitmentRecord_controller {

    @Autowired
    private RecruitmentRecordService recruitmentRecordService;

    /**
     * 投递简历
     * recid 是 招聘的  id
     * @return
     */
    @RequestMapping("/sendresumemake")
    public void sendresumemake(int recId, HttpSession session, HttpServletResponse response) throws IOException {
        Account account = (Account) session.getAttribute("user");

        if(account==null){
            response.getWriter().print("-1");
        }else{
            boolean res = recruitmentRecordService.addRecruitmentRecord(recId,account);
            if(res){
                response.getWriter().print("1");
            }else{
                response.getWriter().print("0");
            }
        }


    }

    @RequestMapping("/queryrecruitmentRecord")
    public String queryrecruitmentRecord(int recId, String current, Model model){
        //总共有多少数据
        List<RecruitmentRecord> all = recruitmentRecordService.queryRecruitmentRecordBy_accId(recId);
        model.addAttribute("all",all.size());
        int pages = PagesUtil.getPages(all.size());
        //当前页数
        int page = PagesUtil.getAllPage(current);
        model.addAttribute("pages",pages);
        //得到前一页和后一页
        PagesUtil.getPre_next_page(page,pages,model);

        List<RecruitmentRecord> recruitmentRecords = recruitmentRecordService.queryRecruitmentRecordBy_accId_everyPae(recId,page);
        model.addAttribute("recruitmentRecords",recruitmentRecords);
        return "";
    }

}
