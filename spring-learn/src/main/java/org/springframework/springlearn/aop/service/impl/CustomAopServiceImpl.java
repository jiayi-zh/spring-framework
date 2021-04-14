package org.springframework.springlearn.aop.service.impl;

import org.springframework.springlearn.aop.service.CustomAopService;

/**
 * AOP 测试 Service
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 8:50
 **/
public class CustomAopServiceImpl implements CustomAopService {

	@Override
	public String doSomeThing(String param) {
		return "do something return: " + param;
	}
}
