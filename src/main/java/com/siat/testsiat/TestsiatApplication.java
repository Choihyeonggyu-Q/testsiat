package com.siat.testsiat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestsiatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsiatApplication.class, args);
	}

}
