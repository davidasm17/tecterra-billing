package com.tecterra.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tecterra.billing.infrastructure.adapters.output.rest")
public class TecterraBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecterraBillingApplication.class, args);
	}

}
