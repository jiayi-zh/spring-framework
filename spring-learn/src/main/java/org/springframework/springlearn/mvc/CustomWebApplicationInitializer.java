package org.springframework.springlearn.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * {@link WebApplicationInitializer} 实现, Tomcat 启动时回调此接口
 *
 * @author ZhengYu
 * @version 1.0 2021/5/8 23:43
 **/
public class CustomWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext annotationConfigApplicationContext = new AnnotationConfigWebApplicationContext();
		//使用注解形式配置springmvc
		annotationConfigApplicationContext.register(CustomMvcConfig.class);

		annotationConfigApplicationContext.refresh();

		//配置springmvc的dispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(annotationConfigApplicationContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
}
