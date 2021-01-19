package org.springframework.springlearn.conversion.propertyeditor.springway;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.springlearn.entity.User;

/**
 * {@link java.beans.PropertyEditor} 类型转换测试 - 与 Spring 整合
 * <p>
 * Spring内建的 PropertyEditor 实现:
 * {@link org.springframework.beans.propertyeditors.ByteArrayPropertyEditor}
 * {@link org.springframework.beans.propertyeditors.CharacterEditor} etc
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 16:59
 **/
public class PropertyEditorSpringTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:conversion/spring-propertyEditor.xml");

		User user = applicationContext.getBean("user", User.class);
		System.out.println("使用自定义的 PropertyEditorRegistrar 类型转换的Bean: " + user);

		applicationContext.close();
	}
}
