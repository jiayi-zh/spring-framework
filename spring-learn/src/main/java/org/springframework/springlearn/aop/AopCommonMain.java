package org.springframework.springlearn.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.springlearn.aop.pointcut.CustomAopServiceStaticMethodMatcherPointcut;
import org.springframework.springlearn.aop.service.CustomAopService;

import java.lang.reflect.Method;

/**
 * Spring AOP 学习
 *
 * @author ZhengYu
 * @version 1.0 2021/4/6 19:43
 **/
public class AopCommonMain {
	public static void main(String[] args) throws InterruptedException {
		Advice advice = new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("MethodBeforeAdvice");
			}
		};

		DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(new CustomAopServiceStaticMethodMatcherPointcut(), advice);

		CustomAopService customAopService = new CustomAopService();
		ProxyFactory proxyFactory = new ProxyFactory(customAopService);
		proxyFactory.addAdvisor(defaultPointcutAdvisor);

		CustomAopService proxy = (CustomAopService) proxyFactory.getProxy();
		proxy.doSomeThing();
	}
}
