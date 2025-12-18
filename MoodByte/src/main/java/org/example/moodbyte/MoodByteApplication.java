package org.example.moodbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.example")
@EntityScan("org.example.Modelo")
@EnableJpaRepositories("org.example")
public class MoodByteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodByteApplication.class, args);
	}

}
