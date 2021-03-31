package org.springframework.springlearn.sourcetracking.importsource.beanclass;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.springlearn.entity.User;

/**
 * 被导入类 - 将其创建为Bean放入IOC容器
 *
 * @author ZhengYu
 * @version 1.0 2021/3/30 11:34
 **/
public class ImportedClazz implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 注册自己的 BeanDefinition
		System.out.println(importingClassMetadata);
	}

	@Bean
	public User user() {
		User user = new User();
		user.setId(1L);
		user.setName("import");
		return user;
	}

	public void selfIntroduce() {
		System.out.println("i am " + this);
	}
}