package com.cybercom.demo;

import com.cybercom.demo.resource.PersonResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(PersonResource.class);
	}

}
