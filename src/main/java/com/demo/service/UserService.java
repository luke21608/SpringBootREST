package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.mapper.demo.DemoMapper;

@Service
public class UserService {
	
	@Autowired
	DemoMapper demoMapper;

	public void printEmail(String id) {
		User user = demoMapper.queryById(id);
		System.out.println(user != null ? user.getEmail() : "no data");
	}
}
