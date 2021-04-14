package org.springframework.springlearn.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * BeforeAdvice
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 8:54
 **/
public class CustomBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("MethodBeforeAdvice --> method:[%s] args:[%s] target:[%s] %n", method.toString(), Arrays.toString(args), target == null ? null : target.toString());
	}
}
