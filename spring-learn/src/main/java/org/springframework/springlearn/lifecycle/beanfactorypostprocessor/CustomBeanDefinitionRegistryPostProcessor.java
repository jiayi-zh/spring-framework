package org.springframework.springlearn.lifecycle.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor} 实现
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 14:34
 **/
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	private final String type;

	private final AtomicInteger postProcessBeanFactoryCounter = new AtomicInteger();

	private final AtomicInteger postProcessBeanDefinitionRegistryCounter = new AtomicInteger();

	/**
	 * 类型 用来标识 BeanFactory 创建还是 @Bean注入
	 *
	 * @param type beanFactory / bean
	 * @author ZhengYu
	 */
	public CustomBeanDefinitionRegistryPostProcessor(String type) {
		this.type = type;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomBeanDefinitionRegistryPostProcessor.class.getName(),
				"postProcessBeanFactory",
				postProcessBeanFactoryCounter.getAndIncrement());
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomBeanDefinitionRegistryPostProcessor.class.getName(),
				"postProcessBeanDefinitionRegistry",
				postProcessBeanDefinitionRegistryCounter.getAndIncrement());
	}
}
