package com.hcl.app.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class EurekaClientDepartmentServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Dept service, which is discovery server aware, and this service will Call Employee Microservice, fro employee details, which is again dicovery server aware!!! "));
	}

}
