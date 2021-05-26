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

	/**
	 * 注入时机: {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement#inject(java.lang.Object, java.lang.String, org.springframework.beans.PropertyValues)}
	 */
	@Autowired
	private User user1;

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

	/**
	 * 注入时机: {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredMethodElement#inject(java.lang.Object, java.lang.String, org.springframework.beans.PropertyValues)}
	 */
	@Autowired
	public void setUser(User user) {
		AutowiredAnnotationBeanPostProcessorProcessDetail.user = user;
	}
}
