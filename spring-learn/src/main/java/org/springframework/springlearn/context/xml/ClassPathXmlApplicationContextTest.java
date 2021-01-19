package org.springframework.springlearn.context.xml;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.springlearn.entity.User;

/**
 * {@link org.springframework.context.support.ClassPathXmlApplicationContext} 源码剖析
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 15:46
 **/
public class ClassPathXmlApplicationContextTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context/spring-propertyEditor.xml");

		User userXml = applicationContext.getBean("user_xml", User.class);
		System.out.println("从 xml 读取 Bean 配置: " + userXml);

		User userFactoryBean = applicationContext.getBean("user_factory_bean", User.class);
		System.out.println("使用 BeanFactory 延迟读取User类型的Bean: " + userFactoryBean);

		ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
		beanProvider.stream().forEach(user -> System.out.println("使用 ObjectProvider 读取User类型的Bean: " + userXml));

		applicationContext.close();
	}
}
