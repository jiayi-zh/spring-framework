package org.springframework.springlearn.sourcetracking.configurationclasspostprocessor.beanclass;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
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
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "import");
		registry.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
	}
}