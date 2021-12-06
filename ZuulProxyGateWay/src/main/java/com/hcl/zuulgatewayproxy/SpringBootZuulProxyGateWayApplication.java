package com.hcl.zuulgatewayproxy;

import com.hcl.zuulgatewayproxy.Filters.ErrorFilter;
import com.hcl.zuulgatewayproxy.Filters.PostFilter;
import com.hcl.zuulgatewayproxy.Filters.PreFilter;
import com.hcl.zuulgatewayproxy.Filters.RouteFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootZuulProxyGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulProxyGateWayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
