package org.springframework.springlearn.springapplicationlifecycle.config;

import org.springframework.context.annotation.Bean;
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

	@Bean
	public CustomBeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor() {
		return new CustomBeanDefinitionRegistryPostProcessor("@Bean");
	}

	@Bean
	public CustomOrderedBeanDefinitionRegistryPostProcessor orderedBeanDefinitionRegistryPostProcessor() {
		return new CustomOrderedBeanDefinitionRegistryPostProcessor("@Bean");
	}

	@Bean
	public CustomPriorityOrderedBeanDefinitionRegistryPostProcessor priorityOrderedBeanDefinitionRegistryPostProcessor() {
		return new CustomPriorityOrderedBeanDefinitionRegistryPostProcessor("@Bean");
	}
}
