package org.springframework.springlearn.aop.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.springlearn.aop.service.CustomAopService;

import java.lang.reflect.Method;

/**
 * {@link StaticMethodMatcherPointcut#matches(Method, Class)} 自定义实现
 *
 * @author ZhengYu
 * @version 1.0 2021/4/7 9:22
 **/
public class CustomAopServiceStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return CustomAopService.class.isAssignableFrom(targetClass) && method.getName().equals("doSomeThing");
	}
}
