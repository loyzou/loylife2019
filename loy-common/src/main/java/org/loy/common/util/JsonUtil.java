/*
 * Copyright (c) 2013, OpenCloudDB/MyCAT and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software;Designed and Developed mainly by many Chinese 
 * opensource volunteers. you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License version 2 only, as published by the
 * Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Any questions about this component can be directed to it's project Web address 
 * https://code.google.com/p/opencloudb/.
 *
 */
package org.loy.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class JsonUtil implements java.io.Serializable {

	private static final long serialVersionUID = -8872078079583695100L;
	private volatile static JsonUtil jsonUtil = null;

	private JsonUtil() {
	}

	public static JsonUtil getInstance() {
		if (jsonUtil == null) {
			synchronized (JsonUtil.class) {
				if (jsonUtil == null) {
					jsonUtil = new JsonUtil();
				}
			}
		}
		return jsonUtil;
	}


	public String object2JSON(Object obj,SerializerFeature... serializerFeature) {
		if(obj == null){
			return "{}";
		}
		return JSON.toJSONString(obj,serializerFeature);
	}
	
	public String object2JSON(Object obj) {
		if(obj == null){
			return "{}";
		}
		return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
	}
	

	public <T>  T json2Object(String json,Class<T> clazz) {
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, clazz);
	}
	
	public <T> T json2Reference(String json, TypeReference<T> reference){
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, reference);
	}
	
	
	/***
	 * 
	 * @param array
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String,Object>>  getListFromJsonArray(JSONArray array) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = (JSONObject) array.get(i);
			Map<String,Object> obj = new LinkedHashMap<String,Object>();
			for (Object key : jsonObject.keySet()) {
				String keyName = key.toString();
				Object value = jsonObject.get(key);
				obj.put(keyName, value);
			}
			list.add(obj);
		}
		return list;
	}
}