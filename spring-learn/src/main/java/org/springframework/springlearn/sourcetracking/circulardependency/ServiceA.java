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
public class ServiceA {

	@Autowired
	private ServiceB serviceB;

	public ServiceA() {
		System.out.println("ServiceA 构造函数");
	}
}
