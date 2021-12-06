package com.hcl.employee.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.hcl.employee.app")
public class EmployeeServiceApplication {
   public static void main(String[] args) {
      SpringApplication.run(EmployeeServiceApplication.class, args);
   }
   
   @Configuration
   class config{
   	
   	@LoadBalanced
   	@Bean
   	public RestTemplate restTemplate() {
   		return new RestTemplate();
   	}
   }
}

