package org.springframework.springlearn.mvc;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * {@link XmlWebApplicationContext} 源码阅读
 *
 * @author ZhengYu
 * @version 1.0 2021/4/6 14:38
 **/
public class XmlWebApplicationContextTest {
	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();

		xmlWebApplicationContext.refresh();
	}
}
