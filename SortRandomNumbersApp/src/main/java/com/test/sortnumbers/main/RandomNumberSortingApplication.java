package com.test.sortnumbers.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.test")
public class RandomNumberSortingApplication {

	public static void main(String[] args) {
			SpringApplication.run(RandomNumberSortingApplication.class, args);
	}
}
