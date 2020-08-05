package ygf.benchmark.json.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

public class JacksonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static Object fromJson(String json, Class<?> type) throws Exception {
        return objectMapper.readValue(json, type);
    }

    public static Object fromJson(String json, TypeReference type) throws Exception{
        return objectMapper.readValue(json, type);
    }
}
