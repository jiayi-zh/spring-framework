package org.springframework.springlearn.circularreference.service;

import org.springframework.stereotype.Component;

/**
 * AService
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 15:54
 **/
@Component
public class BService {

	private AService aService;

	public String test() {
		return BService.class.getName() + "　Aop";
	}
}
