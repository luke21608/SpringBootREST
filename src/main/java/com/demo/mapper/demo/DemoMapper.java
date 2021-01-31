package com.demo.mapper.demo;

import org.apache.ibatis.annotations.Param;

import com.demo.bean.User;

public interface DemoMapper {

	public User queryById(@Param(value="id") String id);
}
