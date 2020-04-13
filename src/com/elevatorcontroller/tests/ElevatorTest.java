package com.elevatorcontroller.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.elevatorcontroller.service.ServiceRequest;
import com.elevatorcontroller.serviceimpl.ServiceRequestImpl;


@RunWith(MockitoJUnitRunner.class)
class ElevatorTest {
	
	@Mock
	ServiceRequestImpl serviceRequest = new ServiceRequestImpl();
	
	@Before
		  public void init() {
		    MockitoAnnotations.initMocks(this);
		}
	  
	  
	  
	 
	@Test
	void LiftGoingUP() {
		serviceRequest.SetLevel(5);
			Assert.assertEquals(false,serviceRequest.GoUP() );
	
	}
	

	

}
