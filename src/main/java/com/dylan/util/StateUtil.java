package com.dylan.util;

import java.util.HashMap;
import java.util.Map;

public class StateUtil {

    public static final int dimission = -1;  //离职  或 删除了

    public static final int regular = 1;  //正常

    public static final int trainee = 0;  //实习生

    public static final String initialPassword = "123456";  //实习生

    public static Map<String,Object> map=new HashMap<>();

    static {
        map.put("regular", StateUtil.regular);
        map.put("dimission",StateUtil.dimission);
        map.put("trainee",StateUtil.trainee);
    }

    public static Map<String ,Object> getMap(){
        return map;
    }
}
