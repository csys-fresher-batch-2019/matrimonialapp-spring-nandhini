package com.nandhini.matrimonyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan("com.nandhini")
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class MatrimonyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrimonyappApplication.class, args);
	}

}
