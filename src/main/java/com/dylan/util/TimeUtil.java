package com.dylan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtil {

    /**
     * 得到某月的第一天  和最后一天的格式
     * @throws ParseException
     */
    public static Map<String,Object> getMonth(Date date){

        Map<String,Object> map=new HashMap<>();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);

        //今天的时间
        map.put("today",cal.get(5));
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //得到某月的第一天
        int first=cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), first, 0, 0, 0);
        String start = sim.format(cal.getTime());
        map.put("start",start);

        //得到某月的最后一天
        int last=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), last, 23, 59, 59);
        String end = sim.format(cal.getTime());
        map.put("end",end);
        //一个月有多少天
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=last;i++){
            list.add(i);
        }
        map.put("max",list);
        return map;
    }

}
