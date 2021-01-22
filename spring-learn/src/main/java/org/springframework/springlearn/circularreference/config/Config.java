package org.springframework.springlearn.circularreference.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Config
 *
 * @author ZhengYu
 * @version 1.0 2021/1/22 15:57
 **/
@Configuration
@ComponentScan("org.springframework.springlearn.circularreference")
@EnableAspectJAutoProxy
public class Config {

}
