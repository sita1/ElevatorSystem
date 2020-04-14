package com.elevatorcontroller.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

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
			Assert.assertEquals("Lift Going up to floor :5" ,serviceRequest.GoUP() );
	
	}
	
	
	@Test
	void LiftGoingDown() {
		serviceRequest.SetLevel(2);
			Assert.assertEquals("Lift Going down to floor :2",serviceRequest.GoDown() );
	
	}
	

	

}
