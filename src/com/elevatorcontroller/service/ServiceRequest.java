package com.elevatorcontroller.service;

import com.elevatorcontroller.Enum.Direction;

public interface ServiceRequest {

	public boolean GoUP();

	public boolean GoDown();

	public int GetLevel();

	public void SetLevel(int level);

	public boolean CanAddLevel(int level);
	
	public void processRequest(int level);
	
	public Direction getDirection();
	

}
