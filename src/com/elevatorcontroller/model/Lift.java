package com.elevatorcontroller.model;

import javax.inject.Inject;

import com.elevatorcontroller.Enum.Direction;

public class Lift {
	
	private String top= "5";
	
	private String ground= "0";
	
	@Inject
	private Direction currenDirection;

	public String getTop() {
		return top;
	}


	public String getGround() {
		return ground;
	}

	public Direction getCurrenDirection() {
		return currenDirection;
	}

	public void setCurrenDirection(Direction currenDirection) {
		this.currenDirection = currenDirection;
	}

	
	
	

}
