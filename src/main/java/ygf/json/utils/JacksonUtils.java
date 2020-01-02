package ygf.json.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static Object fromJson(String json, Class<?> type) throws Exception {
        return objectMapper.readValue(json, type);
    }
}
