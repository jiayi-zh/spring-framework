package org.springframework.springlearn.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC 配置
 *
 * @author ZhengYu
 * @version 1.0 2021/5/8 23:47
 **/
@Configuration
@ComponentScan("org.springframework.springlearn.mvc.controller")
public class CustomMvcConfig implements WebMvcConfigurer {

}
