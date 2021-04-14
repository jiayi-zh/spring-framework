package org.springframework.springlearn.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.springlearn.aop.service.CustomAopService;

/**
 * 基于 XML 配置 AOP
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 9:02
 **/
public class SpringAopByXml {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop/spring-aop-native.xml");

		CustomAopService customAopService = applicationContext.getBean("customAopServiceProxy", CustomAopService.class);

		System.out.println(customAopService.doSomeThing("zy"));
	}
}
