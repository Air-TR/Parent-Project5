package com.tr.p5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tr.p5.mapper")
public class ParentProject5App {

	public static void main(String[] args) {
		SpringApplication.run(ParentProject5App.class, args);
	}
}
