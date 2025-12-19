package com.kubernates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerKubernetesApplication {
	
	@GetMapping("/welcome")
	public String greetings() {
		return "Welcome to spring project and deploy into the kubernetes by help of Jenkins Pipeline ..... !";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerKubernetesApplication.class, args);
	}

}
