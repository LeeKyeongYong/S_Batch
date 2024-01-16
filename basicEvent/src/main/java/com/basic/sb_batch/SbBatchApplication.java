package com.basic.sb_batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SbBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBatchApplication.class, args);
	}

}
