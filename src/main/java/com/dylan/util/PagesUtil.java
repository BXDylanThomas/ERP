package com.dylan.util;

import org.springframework.ui.Model;

import java.util.Map;

/**
 * @author:dylan
 * @create:2018-11-28-17:14
 */
public class PagesUtil {
    public static final int SHOW=6;
    public static int getPages(int allGoods){
        return allGoods% SHOW ==0?allGoods/ SHOW :allGoods/SHOW+1;
    }

    public static Map<String ,Object>  getPage(Map<String,Object> map,int currentPages){
        if(map==null || currentPages<=0){
            return map;
        }
        map.put("current",(currentPages-1)*SHOW+1);
        map.put("show", currentPages*SHOW);
        return map;
    }

    /**
     * 当前页数  如果current  没有  则调到第一页
     * @param current
     * @return
     */
    public static int getAllPage(String current){
        int page=1;
        if(current!=null){
            page=Integer.parseInt(current);
        }
        return page;
    }

    public static void getPre_next_page(int page, int pages, Model model) {
        //前一页 不能小于最小的1
        if(page==1){
            model.addAttribute("prepages",1);
        }else{
            model.addAttribute("prepages",page-1);
        }
        //下一页，不能大于最大的页数
        if(pages==page){
            model.addAttribute("nextpages",page);
        }else{
            model.addAttribute("nextpages",page+1);
        }
    }
}
