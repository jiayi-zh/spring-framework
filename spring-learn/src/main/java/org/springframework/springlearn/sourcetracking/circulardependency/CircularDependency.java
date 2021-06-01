package org.springframework.springlearn.sourcetracking.circulardependency;

import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring 循环依赖
 * 三级缓存:
 * {@link DefaultSingletonBeanRegistry#singletonObjects} 		存放单例Bean
 * {@link DefaultSingletonBeanRegistry#singletonFactories} 		存放Bean的早期Bean工厂方法
 * {@link DefaultSingletonBeanRegistry#earlySingletonObjects}	存放早期Bean
 *
 * @author ZhengYu
 * @version 1.0 2021/6/1 12:52
 **/
@ComponentScan(basePackages = "org.springframework.springlearn.sourcetracking.circulardependency")
public class CircularDependency {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CircularDependency.class);

		Object serviceA = applicationContext.getBean("serviceA");
		Object serviceB = applicationContext.getBean("serviceB");

		applicationContext.close();
	}
}
