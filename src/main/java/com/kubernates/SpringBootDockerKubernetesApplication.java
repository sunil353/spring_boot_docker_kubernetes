package com.kubernates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBootDockerKubernetesApplication {
	
	@GetMapping("/welcome")
	public String greetings() {
		return "Welcome to spring project and deploy to EKS in AWS by help of Jenkins Pipeline ..... !";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerKubernetesApplication.class, args);
	}

}
