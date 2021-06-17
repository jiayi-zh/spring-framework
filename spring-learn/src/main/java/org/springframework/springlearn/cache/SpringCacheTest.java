package org.springframework.springlearn.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Cache 源码分析
 * <p>
 * {@link EnableCaching} 引入配置:
 * {@link org.springframework.context.annotation.AutoProxyRegistrar}: 检测并向Spring容器注入 AbstractAutoProxyCreator Bean
 * {@link org.springframework.cache.annotation.ProxyCachingConfiguration}:
 *
 * @author ZhengYu
 * @version 1.0 2021/6/18 0:14
 **/
@EnableCaching
public class SpringCacheTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(SpringCacheTest.class);

		applicationContext.refresh();

		applicationContext.close();
	}
}
