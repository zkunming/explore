package com.netease.explore.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class CrossFilterConfig {

  @Bean
  public void conf() {
    CorsConfiguration config = new CorsConfiguration();
  }

}
