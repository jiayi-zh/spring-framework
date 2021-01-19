package org.springframework.springlearn.conversion.converter;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.springlearn.entity.User;

/**
 * 自定义 {@link org.springframework.core.convert.converter.ConditionalGenericConverter} 实现
 * {@see org.springframework.core.convert.converter.ConditionalConverter}
 * {@see org.springframework.context.support.ConversionServiceFactoryBean}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 8:40
 **/
public class ConditionalGenericConverterTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:conversion/spring-converter.xml");

		User user = applicationContext.getBean("user", User.class);
		System.out.println("使用自定义的 PropertyEditorRegistrar 类型转换的Bean: " + user);

		applicationContext.close();
	}
}
