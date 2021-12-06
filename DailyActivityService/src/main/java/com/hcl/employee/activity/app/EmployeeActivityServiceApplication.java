package com.hcl.employee.activity.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeActivityServiceApplication {
   public static void main(String[] args) {
      SpringApplication.run(EmployeeActivityServiceApplication.class, args);
   }
}

