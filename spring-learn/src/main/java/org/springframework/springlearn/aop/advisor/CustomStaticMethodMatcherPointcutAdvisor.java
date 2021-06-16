package org.springframework.springlearn.aop.advisor;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.springlearn.aop.service.CustomAopService;

import java.lang.reflect.Method;

/**
 * StaticMethodMatcherPointcutAdvisor
 *
 * @author ZhengYu
 * @version 1.0 2021/6/16 10:14
 **/
public class CustomStaticMethodMatcherPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 8942458006741420909L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return CustomAopService.class.isAssignableFrom(targetClass) && method.getName().equals("doSomeThing");
	}
}
