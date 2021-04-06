package org.springframework.springlearn.mvc;

import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * {@link XmlWebApplicationContext} 源码阅读
 *
 * @author ZhengYu
 * @version 1.0 2021/4/6 14:38
 **/
public class XmlWebApplicationContextTest {
	public static void main(String[] args) {
		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();

		xmlWebApplicationContext.refresh();
	}
}
