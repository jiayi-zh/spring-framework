package org.springframework.springlearn.beanlifecycle.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * CustomInstantiationBeanPostProcessor
 *
 * @author ZhengYu
 * @version 1.0 2021/1/21 13:35
 **/
public class CustomInstantiationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.printf("class: %s, method: %s, beanClass: %s, beanName:%s %n",
				CustomInstantiationBeanPostProcessor.class.getName(),
				"postProcessBeforeInstantiation",
				beanClass.getName(),
				beanClass);
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.printf("class: %s, method: %s, beanClass: %s, beanName:%s %n",
				CustomInstantiationBeanPostProcessor.class.getName(),
				"postProcessAfterInstantiation",
				bean.toString(),
				beanName);
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.printf("class: %s, method: %s, PropertyValues: %s, beanClass: %s, beanName:%s %n",
				CustomInstantiationBeanPostProcessor.class.getName(),
				"postProcessProperties",
				pvs.toString(),
				bean.toString(),
				beanName);
		return null;
	}
}
