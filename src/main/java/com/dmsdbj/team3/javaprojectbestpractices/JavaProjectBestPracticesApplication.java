package com.dmsdbj.team3.javaprojectbestpractices;

import cook.swaggerspringbootstarter.infra.EnableRXSSwagger2;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRXSSwagger2
public class JavaProjectBestPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectBestPracticesApplication.class, args);
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(@Value("spring.application.name") String applicationName) {
		return (registry) -> registry.config().commonTags(
				"application"
				, applicationName);
	}

}
