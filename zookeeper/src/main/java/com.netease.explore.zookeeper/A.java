package com.netease.explore.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class A
{

	@RequestMapping("/")
	String home()
	{
		return "Hello World!";
	}

	public static void main(String[] args)
	{
		SpringApplication.run(A.class);
	}
}
