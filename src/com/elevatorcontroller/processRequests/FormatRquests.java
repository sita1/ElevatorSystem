package com.elevatorcontroller.processRequests;

import javax.inject.Inject;

import com.elevatorcontroller.service.ServiceRequest;

public class FormatRquests {
	
	@Inject
	private ServiceRequest serviceRequest;
	
	
	public void processRequest() {
		
		System.out.println("processRequest");
		
		serviceRequest.addLevel(5);
		serviceRequest.GoUP();
	}

}
