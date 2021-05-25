package org.springframework.springlearn.sourcetracking.autowiredannotationbeanpostprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.springlearn.entity.User;

/**
 * {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor} 测试
 *
 * @author ZhengYu
 * @version 1.0 2021/4/23 17:20
 **/
public class AutowiredAnnotationBeanPostProcessorProcessDetail {

	private static User user;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AutowiredAnnotationBeanPostProcessorProcessDetail.class);
		applicationContext.register(Config.class);

		applicationContext.refresh();

		User user1 = applicationContext.getBean(User.class);
		System.out.println(user1);

		System.out.println(user);

		applicationContext.close();
	}

	@Autowired
	public void setUser(User user) {
		AutowiredAnnotationBeanPostProcessorProcessDetail.user = user;
	}
}
