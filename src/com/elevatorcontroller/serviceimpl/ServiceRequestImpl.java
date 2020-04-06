package com.elevatorcontroller.serviceimpl;

import com.elevatorcontroller.service.ServiceRequest;

public class ServiceRequestImpl implements ServiceRequest {
	
	private String capacity = "200 kg";
	private Integer baseFloor =0;
	private Integer maxFloor = 15;
	
	

	@Override
	public String requestFloor(Integer n) {
		if(n>=baseFloor && n<=maxFloor)
		{
			
		}
		else
		{
			return "Floor is not available";
		}
	
	}

	@Override
	public boolean isUpward() {
		// TODO Auto-generated method stub
		return false;
	}

}
