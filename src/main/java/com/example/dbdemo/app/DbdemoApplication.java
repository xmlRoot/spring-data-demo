package com.example.dbdemo.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(
		info = @Info(
				title = "DBDemo api",
				description = "Example spring data jpa project.",
				version = "0.0.1"
		)
)
@SpringBootApplication(scanBasePackages = "com.example.dbdemo.web")
@EnableJpaRepositories(basePackages = "com.example.dbdemo.repo")
@EntityScan(basePackages = "com.example.dbdemo.entities")
public class DbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbdemoApplication.class, args);
	}

}
