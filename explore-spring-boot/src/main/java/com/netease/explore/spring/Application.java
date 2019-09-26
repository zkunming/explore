package com.netease.explore.spring;

import com.netease.explore.spring.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.dianrong.moat"})
@EnableAspectJAutoProxy
public class Application {

  @RequestMapping("/")
  public String index() {
    return "Hello!";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Autowired
  private DataSourceConfig dataSourceConfig;

}
