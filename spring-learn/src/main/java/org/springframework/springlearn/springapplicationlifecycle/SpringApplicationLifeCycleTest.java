package org.springframework.springlearn.springapplicationlifecycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomBeanDefinitionRegistryPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomOrderedBeanDefinitionRegistryPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.beanfactorypostprocessor.CustomPriorityOrderedBeanDefinitionRegistryPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.beanpostprocessor.CustomBeanPostProcessor;
import org.springframework.springlearn.springapplicationlifecycle.config.Config;

/**
 * Spring 应用上下文生命周期测试
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 13:53
 **/
public class SpringApplicationLifeCycleTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(Config.class);

		// BeanFactoryPostProcessor
		addCustomBeanFactoryPostProcessor(applicationContext);

		// BeanPostProcessor
		//noinspection ConstantConditions
		addCustomBeanPostProcessor((ConfigurableListableBeanFactory) applicationContext);

		applicationContext.refresh();

		applicationContext.close();
	}

	private static void addCustomBeanFactoryPostProcessor(AbstractApplicationContext applicationContext) {
		applicationContext.addBeanFactoryPostProcessor(new CustomBeanDefinitionRegistryPostProcessor("beanFactory"));
		applicationContext.addBeanFactoryPostProcessor(new CustomOrderedBeanDefinitionRegistryPostProcessor("beanFactory"));
		applicationContext.addBeanFactoryPostProcessor(new CustomPriorityOrderedBeanDefinitionRegistryPostProcessor("beanFactory"));
	}

	private static void addCustomBeanPostProcessor(ConfigurableListableBeanFactory applicationContext) {
		applicationContext.addBeanPostProcessor(new CustomBeanPostProcessor("configurableListableBeanFactory"));
	}
}
