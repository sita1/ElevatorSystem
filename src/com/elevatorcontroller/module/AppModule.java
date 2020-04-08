package com.elevatorcontroller.module;

import com.elevatorcontroller.service.ServiceRequest;
import com.elevatorcontroller.serviceimpl.ServiceRequestImpl;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
	
	@Override
	protected void configure() {
	bind(ServiceRequest.class).to(ServiceRequestImpl.class);
	
	}
}