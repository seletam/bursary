package com.bursary.bursary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@ComponentScan(basePackages = { "com.bursary.bursary.controller", "com.bursary.bursary.entities",
		"com.bursary.bursary.enumerator", "com.bursary.bursary.services", "com.bursary.bursary.error",
		"com.bursary.bursary.repository" })
@PropertySource("classpath:application.properties")
public class BursaryApplication {

	public static void main(String[] args) {
		// log.info("test");
		SpringApplication.run(BursaryApplication.class, args);
	}

//	public void run(ApplicationArguments applicationArguments) {
//		log.info("Spring EmailResource - Sending Simple Email with JavaMailSender Example");
//		
//		EmailResource emailResource = new EmailResource();
//		emailResource.setFrom("seletam@gmail.com");
//		emailResource.setTo("seletam@gmail.com");
//		emailResource.setSubject("Spring Boot test");
//		emailResource.setContent("hello, this is spring boot number 1");
//		
//		emailService.sendMessage(emailResource);
//	}
}
