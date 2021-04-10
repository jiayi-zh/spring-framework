package org.springframework.springlearn.aop.service;

/**
 * 被拦截的方法
 *
 * @author ZhengYu
 * @version 1.0 2021/4/7 9:24
 **/
public class CustomAopService {

	public void doSomeThing() {
		System.out.println("org.springframework.springlearn.aop.common.CustomAopService#doSomeThing()");
	}
}
