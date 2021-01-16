package com.mingshashan.learn.netty.rpc.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * JSONUtils
 *
 * @author xufj
 */
public class JSONUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // 忽略空值

//        Hibernate5Module hibernate5Module = new Hibernate5Module();
//        hibernate5Module.configure(Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);
//        objectMapper.registerModule(hibernate5Module);
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String json = objectMapper.writeValueAsString(obj);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
//            log.error(e.toString(), e);
//            throw CofErrorCode.OBJECT_TO_JSON_ERROR.runtimeException(e, obj, e.getMessage());
            try {
                throw e;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    public static byte[] toJsonBytes(Object obj) {
        if (null == obj) {
            return null;
        }
        try {
            byte[] json = objectMapper.writeValueAsBytes(obj);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
//            log.error(e.toString(), e);
//            throw CofErrorCode.OBJECT_TO_JSON_ERROR.runtimeException(e, obj, e.getMessage());
            try {
                throw e;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        if (null == json || 0 == json.length()) {
            return null;
        }
        try {
            T obj = objectMapper.readValue(json, clazz);
            return obj;
        } catch (Throwable e) {
            try {
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            e.printStackTrace();
//            log.error(e.toString(), e);
//            throw CofErrorCode.JSON_TO_OBJECT_ERROR.runtimeException(e, clazz.getName(), e.getMessage());
        }
        return null;
    }

    public static <T> T toObject(byte[] bytes, Class<T> clazz) {
        if (null == bytes || 0 == bytes.length) {
            return null;
        }
        try {
            T obj = objectMapper.readValue(bytes, clazz);
            return obj;
        } catch (Throwable e) {
            try {
                throw e;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            e.printStackTrace();
//            log.error(e.toString(), e);
//            throw CofErrorCode.JSON_TO_OBJECT_ERROR.runtimeException(e, clazz.getName(), e.getMessage());
        }
        return null;
    }
}
