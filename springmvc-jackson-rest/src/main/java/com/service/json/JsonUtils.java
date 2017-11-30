package com.service.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	/**
	 * Transform json string to java bean object
	 * 
	 * @param json
	 * @param bean
	 * @return Object
	 */
	@SuppressWarnings("finally")
	public static Object json2Object(String json, Object bean) {
		try {
			bean = (new ObjectMapper()).readValue(json, bean.getClass());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return bean;
		}
	}

	/**
	 * Transform json string to java bean object
	 * 
	 * @param json
	 * @param Class
	 * @return Object
	 */
	@SuppressWarnings("finally")
	public static <T> T json2Object(String json, Class<T> cls) {
		T bean = null;
		try {
			bean = (new ObjectMapper()).readValue(json, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return bean;
		}
	}

	/**
	 * Transform java bean object to json string
	 * 
	 * @param bean
	 * @return string
	 */
	@SuppressWarnings("finally")
	public static String object2Json(Object bean) {
		String json = "";
		try {
			json = (new ObjectMapper()).writeValueAsString(bean);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return json;
		}
	}

	/**
	 * prettyJson use jackson
	 * 
	 * @param bean
	 * @return String
	 */
	public static String pretty(Object bean) {
		String prettyJson = "";
		try {
			prettyJson = (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prettyJson;
	}
}
