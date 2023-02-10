package org.insta.application.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class JsonTool {

    public static String toString(Object obj) {
        try {
            ObjectMapper ob = new ObjectMapper();
            return ob.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JsonTool.toString : data  ={}, error={}",obj,e.toString());
        }
        return "";
    }

    public static <T> T toObject (String data, Class<T> c) {
        try {
            ObjectMapper om = new ObjectMapper();
            return om.readValue(data,c);
        } catch (JsonProcessingException e) {
            log.error("JsonTool.toObjet: data={}, class={}",data,c.getTypeName());
        }
        return null;
    }

    public static Map<String,Object> toMap(String data) {
        try {
            ObjectMapper om = new ObjectMapper();
            return om.readValue(data, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("JsonTool.toMap: data={}, error={}",data,e.toString());
        }
        return null;
    }

    public static List<Object> toList(String data) {
        try {
            ObjectMapper om = new ObjectMapper();
            return om.readValue(data, new TypeReference<List<Object>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("JsonTool.toList: data={}, error={}",data,e.toString());
        }
        return null;
    }
}
