package io.getarrays.apiapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApiapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiapplicationApplication.class, args);
	}

}
