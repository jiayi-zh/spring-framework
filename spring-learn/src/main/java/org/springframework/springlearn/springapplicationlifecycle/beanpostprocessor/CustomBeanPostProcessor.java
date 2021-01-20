package org.springframework.springlearn.springapplicationlifecycle.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link org.springframework.beans.factory.config.BeanPostProcessor}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 17:06
 **/
public class CustomBeanPostProcessor implements BeanPostProcessor {


	private final String type;

	private final AtomicInteger postProcessBeforeInitializationCounter = new AtomicInteger();

	private final AtomicInteger postProcessAfterInitializationCounter = new AtomicInteger();

	public CustomBeanPostProcessor(String type) {
		this.type = type;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomBeanPostProcessor.class.getName(),
				"postProcessBeforeInitialization",
				postProcessBeforeInitializationCounter.getAndIncrement());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.printf("type:%s, class:%s, method:%s counter:%d %n",
				type,
				CustomBeanPostProcessor.class.getName(),
				"postProcessAfterInitialization",
				postProcessAfterInitializationCounter.getAndIncrement());
		return bean;
	}
}
