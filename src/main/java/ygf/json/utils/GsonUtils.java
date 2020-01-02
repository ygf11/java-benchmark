package ygf.json.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * gson util class
 *
 * @author yanggaofeng
 * @date 20200102
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static Object fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static Object fromJson(String json, Class<?> type) {
        return gson.fromJson(json, type);
    }
}
