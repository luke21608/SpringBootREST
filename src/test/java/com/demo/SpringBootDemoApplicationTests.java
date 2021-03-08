package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.mapper.demo.DemoMapper;
import com.demo.mapper.test.TestMapper;
import com.demo.service.UserService;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private DemoMapper demoMapper;
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private UserService userService;
	
	@Test
	void contextLoads() {
		System.out.println("========== contextLoads ==========");

	}

//	@Test
//	void demoMapperTest() {
//		System.out.println(demoMapper.queryById("Luke"));
//	}
//	
//	@Test
//	void testMapperTest() {
//		System.out.println(testMapper.queryByUserId("Kobe"));
//	}
//	
//	@Test
//	void testPrintEmail() {
//		userService.printEmail("Luke");
//	}
}
