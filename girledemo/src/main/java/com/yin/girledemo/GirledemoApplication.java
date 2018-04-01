package com.yin.girledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GirledemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirledemoApplication.class, args);
	}
}
