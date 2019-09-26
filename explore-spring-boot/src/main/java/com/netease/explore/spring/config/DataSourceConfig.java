package com.netease.explore.spring.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnMissingBean
public class DataSourceConfig {

  @Bean
  public DataSource dataSource() {

    return null;
  }
}
