package org.springframework.springlearn.sourcetracking.beanconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.springlearn.entity.User;

import java.util.Map;

/**
 * 探索 @Bean 注解作用于 静态方法与非静态方法时 处理逻辑
 *
 * @author ZhengYu
 * @version 1.0 2021/5/25 13:30
 **/
@ComponentScan("org.springframework.springlearn.sourcetracking.beanconfig.config")
public class BeanAnnotationProcessDetail {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanAnnotationProcessDetail.class);

		applicationContext.refresh();

		Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
		System.out.println(beansOfType);

		applicationContext.close();
	}
}
