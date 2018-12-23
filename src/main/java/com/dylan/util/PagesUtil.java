package com.dylan.util;

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

}
