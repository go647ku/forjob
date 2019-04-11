package com.jt.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
	private static ObjectMapper mapper=new ObjectMapper();
	public static String toJson(Object object) {
		String json=null;
		try {
			json=mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return json;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String json,Class<T> targetClass) {
		T t=null;//定义泛型对象 本来是object对象
		try {
			t= mapper.readValue(json, targetClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw new RuntimeException();
		}
		return t;
	}
}
