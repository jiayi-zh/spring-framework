package org.springframework.springlearn.sourcetracking.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2021/6/1 12:53
 **/
@Component
public class ServiceB {

	@Autowired
	private ServiceA serviceA;

	public ServiceB() {
		System.out.println("ServiceB 构造函数");
	}
}
