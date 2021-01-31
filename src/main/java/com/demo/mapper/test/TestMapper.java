package com.demo.mapper.test;

import org.apache.ibatis.annotations.Param;

import com.demo.bean.Login;

public interface TestMapper {

	public Login queryByUserId(@Param(value="userId") String userId);
}
