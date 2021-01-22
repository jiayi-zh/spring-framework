package org.springframework.springlearn.circularreference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.springlearn.circularreference.config.Config;
import org.springframework.springlearn.circularreference.service.AService;
import org.springframework.springlearn.circularreference.service.BService;

/**
 * Spring 循环依赖过程解析
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 10:31
 **/
public class CircularReferenceMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(Config.class);

		applicationContext.refresh();

		AService aService = applicationContext.getBean(AService.class);
		BService bService = applicationContext.getBean(BService.class);

		System.out.println(aService + " === " + bService);
	}
}
