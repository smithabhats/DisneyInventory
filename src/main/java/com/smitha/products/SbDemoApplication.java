package com.smitha.products;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class SbDemoApplication {

	public static void main(String[] args) {
		log.info("In SbDemoApplication.main method");
		SpringApplication.run(SbDemoApplication.class, args);
	}

}
