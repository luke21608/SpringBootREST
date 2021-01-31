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
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(3);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        
		for(Integer number: numbers) {
			if(!map.containsKey(number)) {
				map.put(number, number);
			}
		}
    	System.out.println(map);
    	
        Integer[] nums = new Integer[map.size()];

        for (Object key : map.keySet()) {
        	   nums[index] = map.get(key);
        	   ++index;
        }
    	
		int k = 1;
        int count = 0;

        for(int i=0;i<nums.length;i++){
        	System.out.print(nums[i] + ",");

        }

        for(int i=0;i<nums.length-1;i++){
        	System.out.println("=============================");
        	System.out.println(nums[i]);

            for(int j=i+1;j<nums.length;j++){
            	System.out.println(nums[j]);

                if(nums[i] + k == nums[j]){

                    count++;

                }
            }
        }
    	System.out.println("count ===> " + count);

//		String s = "abcab";
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        String key = "";
//        int count = 0;
//        
//        for(int i=0;i<s.length();i++){
//            key = String.valueOf(s.charAt(i));
//    		System.out.println(key);
//
//            map.put(key, map.getOrDefault(key, 0)+1);
//        }
//    
//		System.out.println(map);
//
//        for(Object obj: map.keySet()){
//    		System.out.println(map.get(obj));
//
//        }

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
