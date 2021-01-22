package org.springframework.springlearn.circularreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AService
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 15:54
 **/
@Component
public class AService {

	@Autowired
	private BService bService;
}
