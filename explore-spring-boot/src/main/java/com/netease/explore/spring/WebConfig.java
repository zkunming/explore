package com.netease.explore.spring;

import com.netease.explore.core.SpringContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //日志拦截器
    //registry.addInterceptor(new LogInterceptor()).addPathPatterns(Lists.newArrayList("/**"));
  }

	/*@Bean
	public SnowflakeIdWorker snowflakeIdWorker()
	{
		return new SnowflakeIdWorker(0, 0);
	}*/

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContext.setApplicationContextByOuter(applicationContext);
  }
}