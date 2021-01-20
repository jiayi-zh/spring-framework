package org.springframework.springlearn.beanlifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.springlearn.entity.User;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomBeanDefinitionRegistryPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomOrderedBeanDefinitionRegistryPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomPriorityOrderedBeanDefinitionRegistryPostProcessor;

/**
 * 自定义Bean实现
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 14:40
 **/
public class Config {

	@Bean(name = "annotatedUser")
	public User user() {
		User user = new User();
		user.setId(4L);
		user.setName("annotatedUser");
		return user;
	}
}
