package org.springframework.springlearn.aop.main;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.springlearn.aop.advice.CustomBeforeAdvice;
import org.springframework.springlearn.aop.advisor.CustomStaticMethodMatcherPointcutAdvisor;
import org.springframework.springlearn.aop.service.CustomAopService;
import org.springframework.springlearn.aop.service.impl.CustomAopServiceImpl;

/**
 * AOP API 测试主类
 *
 * @author ZhengYu
 * @version 1.0 2021/6/15 23:45
 **/
public class AopNativeApi {
	public static void main(String[] args) {
		// 创建 AopProxyFactory
		AopProxyFactory aopProxyFactory = new DefaultAopProxyFactory();

		// AdvisedSupport:
		// 1. 父类 ProxyConfig: 提供了生成代理对象的配置，比如是否暴漏给上下文, 是否使用JDK动态代理等
		// 2. 父接口 Advised: 管理 Advice/Advisor
		// AdvisedSupport 通过持有一个 AdvisorChainFactory, 根据给定的类及方法, 过滤并返回所有符合条件的 Advisor 转换为 Interceptors/DynamicInterceptionAdvice
		AdvisedSupport advisedSupport = new AdvisedSupport();
		// ProxyConfig 相关配置
		advisedSupport.setProxyTargetClass(true);
		advisedSupport.setExposeProxy(true);
		// 设置被代理对象的 TargetSource
		advisedSupport.setTargetSource(new SingletonTargetSource(new CustomAopServiceImpl()));
		// 管理 Advisor
		CustomStaticMethodMatcherPointcutAdvisor pointcutAdvisor = new CustomStaticMethodMatcherPointcutAdvisor();
		pointcutAdvisor.setAdvice(new CustomBeforeAdvice());
		advisedSupport.addAdvisor(pointcutAdvisor);

		// 创建 AopProxy
		AopProxy aopProxy = aopProxyFactory.createAopProxy(advisedSupport);

		CustomAopService customAopService = (CustomAopService) aopProxy.getProxy();
		String result = customAopService.doSomeThing("aop native api");
		System.out.println(result);
	}
}
