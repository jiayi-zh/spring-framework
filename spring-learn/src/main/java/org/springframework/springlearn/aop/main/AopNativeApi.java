package org.springframework.springlearn.aop.main;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.DefaultAopProxyFactory;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2021/6/15 23:45
 **/
public class AopNativeApi {
	public static void main(String[] args) {
		AopProxyFactory aopProxyFactory = new DefaultAopProxyFactory();

		AdvisedSupport advisedSupport = new AdvisedSupport();
		advisedSupport.setExposeProxy(true);
//		advisedSupport.addAdvice();

		AopProxy aopProxy = aopProxyFactory.createAopProxy(advisedSupport);
	}
}
