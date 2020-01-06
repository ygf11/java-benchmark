package ygf.json.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;


public class FastJsonUtils {
    public static String toJson(Object object){
        return JSON.toJSONString(object);
    }

    public static Object fromJson(String json, Class<?> type){
        return JSON.parseObject(json, type);
    }

    public static Object fromJson(String json, TypeReference type){
        return JSON.parseObject(json, type);
    }
}
