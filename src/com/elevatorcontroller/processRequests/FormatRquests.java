package com.elevatorcontroller.processRequests;

import javax.inject.Inject;

import com.elevatorcontroller.service.ServiceRequest;

public class FormatRquests {
	
	@Inject
	private ServiceRequest serviceRequest;

	
	
	public void processRequest() {
		
		if(serviceRequest.GetLevel()==0)
		{
			 serviceRequest.inputEveryFiveSecond();
			
	
		}
			
		
	}

}
