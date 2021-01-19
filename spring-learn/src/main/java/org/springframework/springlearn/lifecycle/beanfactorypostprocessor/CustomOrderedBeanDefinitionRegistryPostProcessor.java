package org.springframework.springlearn.lifecycle.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不带优先级排序{@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor} 实现
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 14:34
 **/
public class CustomOrderedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {

	private final String type;

	private final AtomicInteger postProcessBeanFactoryCounter = new AtomicInteger();

	private final AtomicInteger postProcessBeanDefinitionRegistryCounter = new AtomicInteger();

	public CustomOrderedBeanDefinitionRegistryPostProcessor(String type) {
		this.type = type;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomOrderedBeanDefinitionRegistryPostProcessor.class.getName(),
				"postProcessBeanFactory",
				postProcessBeanFactoryCounter.getAndIncrement());
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomOrderedBeanDefinitionRegistryPostProcessor.class.getName(),
				"postProcessBeanDefinitionRegistry",
				postProcessBeanDefinitionRegistryCounter.getAndIncrement());
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
