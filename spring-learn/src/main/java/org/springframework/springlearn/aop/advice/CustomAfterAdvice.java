package org.springframework.springlearn.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * AfterReturningAdvice
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 8:58
 **/
public class CustomAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("MethodBeforeAdvice --> returnV:[%s] method:[%s] args:[%s] target:[%s] %n", returnValue == null ? null : returnValue.toString(), method.toString(), Arrays.toString(args), target == null ? null : target.toString());
	}
}
