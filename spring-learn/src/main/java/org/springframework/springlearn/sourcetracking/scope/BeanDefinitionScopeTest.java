package org.springframework.springlearn.sourcetracking.scope;

import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.springlearn.entity.User;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} Scope 非单例、原型场景
 *
 * @author ZhengYu
 * @version 1.0 2021/7/16 9:29
 **/
public class BeanDefinitionScopeTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class)
				.setScope("refresh")
				.addPropertyValue("id", 1L)
				.getBeanDefinition();
		beanFactory.registerBeanDefinition("user", beanDefinition);

		// 注册一个refresh对应的Scope
		Scope refreshScope = new CustomSimpleMapScope();
		beanFactory.registerScope("refresh", refreshScope);

		// 第一次创建Bean, 这个Bean将被创建并缓存在Scope中, 注意：这时候创建的Bean不会放在 singletonObjects 中，这也就解释了每个 Scope 都对应了不同的存储实现
		beanFactory.getBean("user", User.class);

		// 第二次获取Scope，还是会走创建的流程，从Scope中获取时会走缓存，不会重新创建
		beanFactory.getBean("user", User.class);

		// 清除掉Scope中缓存的Bean，重新获取
		refreshScope.remove("user");
		// 此时会重新创建Bean
		beanFactory.getBean("user", User.class);
	}
}
