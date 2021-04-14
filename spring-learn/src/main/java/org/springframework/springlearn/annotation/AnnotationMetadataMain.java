package org.springframework.springlearn.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link org.springframework.core.type.AnnotationMetadata}
 * 工厂方法 {@link org.springframework.core.type.AnnotationMetadata#introspect(Class)} 来创建 {@link org.springframework.core.type.AnnotationMetadata}
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 13:03
 **/
@RestController("restController")
@Component("component")
@ComponentScan(lazyInit = true, basePackageClasses = {String.class, HashMap.class})
public class AnnotationMetadataMain {
	public static void main(String[] args) {
		AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(AnnotationMetadataMain.class);
		// 获取所有的注解类型
		System.out.println("------------------------------------------------------------------------------");
		annotationMetadata.getAnnotationTypes().forEach(System.out::println);
		// 获取注解的所有属性
		System.out.println("------------------------------------------------------------------------------");
		Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
		System.out.println(annotationAttributes);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
