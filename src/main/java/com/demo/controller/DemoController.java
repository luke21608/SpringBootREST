package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class DemoController extends BaseController{

	@Value("${spring.profiles.active}")
	public String env;
	@Value("${author.name}")
	public String authorName;
	@Value("${author.email}")
	public String authorEmail;
	
//	@RequestMapping(value="/")
//	public String hello() {
//		return "hello";
//	}
	
	@ApiOperation(value = "測試hello", notes = "")
	@RequestMapping(value = "/demo/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloApi() {
		System.out.println("@env ==> " + env);
		System.out.println("@authorName ==> " + authorName);
		System.out.println("@authorEmail ==> " + authorEmail);
		return "helloApi";
	}
	
	@ApiOperation(value = "測試params")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "綽號", name = "nickName", dataType = "String", required = true, defaultValue = "damn"),
		@ApiImplicitParam(value = "email", name = "email", dataType = "String", required = false, defaultValue = "gmail"),
	})
	@RequestMapping(value = "/demo/a1/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String testParams(HttpServletRequest request, HttpServletResponse reponse,
			@RequestParam String nickName, @RequestParam String email) {
		
		User user = new User();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickName", nickName);
		map.put("email", email);
		map.put("user", user);
		
		return mapToJson(map);
	}
	
	@ApiOperation(value = "測試bean")
	@RequestMapping(value = "/demo/a2/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String testBean(HttpServletRequest request, HttpServletResponse reponse,
			@RequestBody User user) {

		System.out.println("@RequestBody ==> " + user);

		return null;
	}
}
