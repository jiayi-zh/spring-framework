package org.springframework.springlearn.context.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.springlearn.entity.User;

import java.util.Map;

/**
 * {@link org.springframework.context.annotation.AnnotationConfigApplicationContext} 源码剖析
 *
 * @author ZhengYu
 * @version 1.0 2021/1/16 22:10
 **/
public class AnnotationConfigApplicationContextTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(BeanConfig.class);

		applicationContext.refresh();

		User annotationUser = applicationContext.getBean("annotationUser", User.class);
		System.out.println("通过@Bean注解查找Bean: " + annotationUser);

		User factoryBeanUser = applicationContext.getBean("factoryBeanUser", User.class);
		System.out.println("通过FactoryBean延迟查找Bean: " + factoryBeanUser);

		Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
		System.out.println("所有 User.class 类型的Bean: " + userMap);

		applicationContext.close();
	}
}
