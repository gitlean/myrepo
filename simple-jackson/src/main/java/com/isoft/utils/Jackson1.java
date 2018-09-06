package com.isoft.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Jackson1 {

	public static void main(String[] args) {
		String str = "{\"data\":{\"number1\":123,\"number2\":123.45600,\"number3\":\"123.45600\""
				+ ",\"number4\":\"\",\"number5\":\"0\",\"number6\":\"null\",\"number7\":null}}";

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(str);

			JsonNode data = root.path("data");

			for (int i = 1; i <= 7; i++) {
				String strNodeName = "number" + String.valueOf(i);

				if (data.has(strNodeName) == true) {
					System.out.println(String.format("原始节点信息 %s", data.get(strNodeName)));

					String str1 = data.get(strNodeName).toString();
					System.out.println(String.format("toString() 输出: %s", str1));

					String str2 = data.get(strNodeName).asText();
					System.out.println(String.format("asText() 输出: %s", str2));

					String str3 = data.get(strNodeName).textValue();
					System.out.println(String.format("textValue() 输出: %s", str3));

					NumberType str4 = data.get(strNodeName).numberType();
					System.out.println(String.format("numberType() 显示: %s", str4));

					System.out.println("-----------------------------------------------");
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
