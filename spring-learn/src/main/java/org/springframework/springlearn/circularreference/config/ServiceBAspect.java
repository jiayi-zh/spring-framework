package org.springframework.springlearn.circularreference.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * {@link org.springframework.springlearn.circularreference.service.BService}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 15:58
 **/
@Aspect
@Component
public class ServiceBAspect {

	@Around("execution(* org.springframework.springlearn.circularreference.service.BService.test())")
	public void invoke(ProceedingJoinPoint point) {
		System.out.println("aop around before ...");

		try {
			point.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		System.out.println("aop around after ...");
	}
}
