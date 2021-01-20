package org.springframework.springlearn.beanlifecycle;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.springlearn.beanlifecycle.config.Config;
import org.springframework.springlearn.entity.User;

import java.util.Map;

/**
 * Spring Bean 元信息配置与解析阶段
 * {@link org.springframework.beans.factory.support.BeanDefinitionReader}
 * {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}
 * {@link org.springframework.beans.factory.support.PropertiesBeanDefinitionReader}
 * <p>
 * {@link AnnotatedBeanDefinitionReader}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/21 5:04
 **/
public class _01_MetadataConfig {
	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext();

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

		applicationContext.refresh();

		Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
		System.out.println(userMap);

		applicationContext.close();
	}
}
