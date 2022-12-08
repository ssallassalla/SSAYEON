package com.ssayeon.ssayeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
public class SsayeonApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsayeonApplication.class, args);
		System.out.println("안녕");
	}
}

