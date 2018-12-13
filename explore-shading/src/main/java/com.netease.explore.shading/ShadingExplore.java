package com.netease.explore.shading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.netease.explore")
@EnableTransactionManagement
public class ShadingExplore {

  public static void main(String[] args) {
    SpringApplication.run(ShadingExplore.class);
  }
}
