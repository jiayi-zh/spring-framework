package org.springframework.springlearn.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 方法拦截
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 10:59
 **/
public class CustomMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("around before ###########");
		Object proceed = invocation.proceed();
		System.out.println("around after ###########");
		return proceed;
	}
}
