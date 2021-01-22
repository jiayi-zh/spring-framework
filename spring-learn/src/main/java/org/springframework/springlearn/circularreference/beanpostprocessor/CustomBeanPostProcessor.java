package org.springframework.springlearn.circularreference.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * CustomBeanPostProcessor
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 16:14
 **/
@Component
public class CustomBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
