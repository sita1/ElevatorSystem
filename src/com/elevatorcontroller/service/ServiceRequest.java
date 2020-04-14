package com.elevatorcontroller.service;

import com.elevatorcontroller.Enum.Direction;

public interface ServiceRequest {

	public String GoUP();

	public String GoDown();

	public int GetLevel();

	public void SetLevel(int level);

	public boolean CanAddLevel(int level);
	
	public void processRequest(int level);
	
	public Direction getDirection();
	
	public void inputEveryFiveSecond();
	
	public boolean canAddPerson();
	

}
