package org.springframework.springlearn.beanlifecycle;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.springlearn.beanlifecycle.beanpostprocessor.CustomInstantiationBeanPostProcessor;
import org.springframework.springlearn.beanlifecycle.config.Config;
import org.springframework.springlearn.entity.User;
import org.springframework.springlearn.entity.UserHolder;

import java.beans.PropertyDescriptor;

/**
 * Spring Bean 元信息配置 -> 解析 -> 注册
 * {@link org.springframework.beans.factory.support.BeanDefinitionReader}
 * {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}
 * {@link org.springframework.beans.factory.support.PropertiesBeanDefinitionReader}
 * <p>
 * {@link AnnotatedBeanDefinitionReader}
 * Spring BeanDefinition 合并
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory#getMergedBeanDefinition(String)}
 * {@link org.springframework.beans.factory.support.AbstractBeanFactory#getMergedBeanDefinition(String, BeanDefinition, BeanDefinition)}
 * Spring Bean Class 加载阶段
 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean(String, RootBeanDefinition, Object[])}
 * Spring Bean 实例化前阶段
 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean(String, RootBeanDefinition, Object[])}
 * {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)}
 * Spring Bean 实例化阶段 TODO 需再理解
 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean(String, RootBeanDefinition, Object[])}
 * --> {@link org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition(RootBeanDefinition, Class, String)}
 * Spring Bean 实例化后阶段
 * {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation(Object, String)}
 * Spring Bean 属性赋值前阶段
 * {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)}
 * {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessPropertyValues(PropertyValues, PropertyDescriptor[], Object, String)}
 * Spring Bean 属性赋值阶段
 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#applyPropertyValues(String, BeanDefinition, BeanWrapper, PropertyValues)}
 * Spring Bean Aware 接口回调阶段
 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeAwareMethods(String, Object)}
 * Spring Bean 初始化前阶段
 * {@link org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(Object, String)}
 * Spring Bean 初始化阶段
 * --> {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet()}
 * --> Bean 自身定义的 initMethodName 方法
 * Spring Bean 初始化后阶段
 * {@link org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(Object, String)}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/21 5:04
 **/
public class BeanLifeCycleMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory applicationContext = new DefaultListableBeanFactory();

		// 添加自定义 Bean 实例化生命周期处理
		applicationContext.addBeanPostProcessor(new CustomInstantiationBeanPostProcessor());

		// 面向资源 - XML 配置
		BeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
		xmlBeanDefinitionReader.loadBeanDefinitions("classpath:beanlifecycle/metadataconfig.xml");

		// 面向资源 - Properties 配置
		PropertiesBeanDefinitionReader propBeanDefinitionReader = new PropertiesBeanDefinitionReader(applicationContext);
		propBeanDefinitionReader.loadBeanDefinitions("classpath:beanlifecycle/metadataconfig.properties");

		// 面向注解
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(applicationContext);
		annotatedBeanDefinitionReader.register(Config.class);

		// 面向API
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.
				genericBeanDefinition(User.class).
				addPropertyValue("id", 3L).
				addPropertyValue("name", "beanDefinitionUser").getBeanDefinition();
		applicationContext.registerBeanDefinition("beanDefinitionUser", beanDefinition);

		User user = applicationContext.getBean("user_child", User.class);
		System.out.println(user);

		UserHolder user_holder = applicationContext.getBean("user_holder", UserHolder.class);
		System.out.println(user_holder);

		applicationContext.getBeansOfType(User.class).forEach((k, v) -> System.out.printf("name: %s, bean: %s%n", k, v));
	}
}
