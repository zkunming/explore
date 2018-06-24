package com.netease.explore.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.netease.explore")
@EnableTransactionManagement
public class Application
{
	@RequestMapping("/")
	public String index()
	{
		return "Hello!";
	}

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class);
	}
}
