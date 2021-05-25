package org.springframework.springlearn.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2021/5/8 23:49
 **/
@RestController
public class MvcController {

	@GetMapping("test")
	public String test() {
		return "mvc";
	}
}
