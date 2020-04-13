package com.elevatorcontroller.tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.elevatorcontroller.serviceimpl.ServiceRequestImpl;



class ElevatorTest {
	ServiceRequestImpl serviceRequest =null;
	
	
	@Before
	void setUp() {
		 serviceRequest =  new ServiceRequestImpl();

	
	}
	
	@Test
	void LiftGoingUP() {
		serviceRequest.SetLevel(5);
			Assert.assertEquals(false,serviceRequest.GoUP() );
	
	}
	
	@After
	void tearDown() {
		 serviceRequest = null;

	
	}
	

}
