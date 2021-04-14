package org.springframework.springlearn.aop.main;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;
import org.springframework.springlearn.aop.service.CustomAopService;
import org.springframework.springlearn.aop.service.impl.CustomAopServiceImpl;

import java.util.Arrays;

/**
 * 基于 AspectJ 配置 AOP
 *
 * @author ZhengYu
 * @version 1.0 2021/4/14 9:02
 **/
@Import(AopByAspectJTest.AopConfig.class)
@EnableAspectJAutoProxy
public class AopByAspectJTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AopByAspectJTest.class);

		applicationContext.refresh();

		CustomAopService customAopService = applicationContext.getBean(CustomAopService.class);

		customAopService.doSomeThing("zy");

		applicationContext.close();
	}

	@Bean
	public CustomAopService customAopService() {
		return new CustomAopServiceImpl();
	}

	/* xml方式: <aop:aspectj-autoproxy/> */
	@Aspect
	public static class AopConfig {

		// within：指定所在类或所在包下面的方法            eg: @Pointcut("within(com.javadoop.springaoplearning.service..*)")
		// @annotation: 方法上具有特定的注解              eg: @Pointcut("execution( .*(..)) && @annotation(com.javadoop.annotation.Subscribe)") 只拦截配置了 @Subscribe 的方法
		// bean(idOrNameOfBean): 匹配 bean 的名字        eg: @Pointcut("bean(*Service)")
		@Pointcut("within(org.springframework.springlearn.aop.service..*)")
		public void point() {

		}

		@Before("point()")
		public void before1() {
			System.out.println("before1 ...");
		}

		@Before("point()")
		public void before2(JoinPoint joinPoint) {
			System.out.println("before2 ... args: " + Arrays.toString(joinPoint.getArgs()));
		}

		@AfterReturning("point()")
		public void afterReturning1() {
			System.out.println("afterReturning1 ...");

		}

		@AfterReturning(pointcut = "point()", returning = "retVal")
		public void afterReturning2(Object retVal) {
			System.out.println("afterReturning2 ... args: " + retVal);
		}

		@AfterReturning("point()")
		public void after() {
			System.out.println("after ...");
		}

		@AfterThrowing(pointcut = "point()", throwing = "ex")
		public void doRecoveryActions(DataAccessException ex) {
			System.out.println("afterThrowing ..." + ex.getMessage());
		}

		@Around("point()")
		public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
			// start stopwatch
			System.out.println("around before ...");
			Object retVal = pjp.proceed();
			System.out.println("around after ...");
			// stop stopwatch
			return retVal;
		}
	}
}
