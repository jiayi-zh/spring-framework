package org.springframework.springlearn.sourcetracking.configurationclasspostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.springlearn.entity.User;
import org.springframework.springlearn.sourcetracking.configurationclasspostprocessor.beanclass.ImportedClazz;

/**
 * {@link org.springframework.context.annotation.Import} 源码分析
 *
 * @author ZhengYu
 * @version 1.0 2021/3/30 11:25
 **/
@Import(ImportedClazz.class)
public class ConfigurationAnnotationProcessDetail {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(ConfigurationAnnotationProcessDetail.class);

		applicationContext.refresh();

		User user = applicationContext.getBean(User.class);
		System.out.println(user);

		applicationContext.close();
	}
}
