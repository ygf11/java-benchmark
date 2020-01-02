package ygf.json.utils;

import com.alibaba.fastjson.JSON;

public class FastJsonUtils {
    public static String toJson(Object object){
        return JSON.toJSONString(object);
    }

    public static Object fromJson(String json, Class<?> type){
        return JSON.parseObject(json, type);
    }
}
