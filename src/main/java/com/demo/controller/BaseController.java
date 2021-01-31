package com.demo.controller;

import com.google.gson.Gson;

public class BaseController {
	
	public String mapToJson(Object map) {
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.printf( "mapToJson: %s", json);
		return json;
	}
}
