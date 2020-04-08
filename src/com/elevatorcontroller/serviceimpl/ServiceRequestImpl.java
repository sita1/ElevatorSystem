package com.elevatorcontroller.serviceimpl;

import java.util.LinkedList;
import java.util.Queue;
import com.elevatorcontroller.Enum.Direction;
import com.elevatorcontroller.model.Lift;
import com.elevatorcontroller.service.ServiceRequest;

public class ServiceRequestImpl implements ServiceRequest {

	Queue<Integer> elevQ = new LinkedList<Integer>();
	
	Lift Lift;

	@Override
	public void SetLevel(int level) {
		elevQ.add(level);
	}

	@Override
	public int GetLevel() {
		return elevQ.peek();
	}

	public boolean CanAddLevel(int level) {
		if (Direction.UP.equals(Lift.getCurrenDirection()) && elevQ.peek() < level)
			return true;
		else if (Direction.DOWN.equals(Lift.getCurrenDirection()) && elevQ.peek() > level)
			return true;
		return false;
	}

	@Override
	public boolean GoUP() {
		  do {
			 Integer currentFloor = elevQ.peek();
			  removeVisitingFloor();
			 
			 System.out.print("Lift Going up to floor :" + currentFloor);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		  }while(elevQ.size()>0);
		  
	        if (elevQ.size() > 0) {
	        	Lift.setCurrenDirection(Direction.DOWN); 
	        	GoDown();
	        } else {
	        	Lift.setCurrenDirection(Direction.NONE); 
	        }
			return false;
		  
		  
	}

	private void removeVisitingFloor() {
		elevQ.remove();
		
	}

	@Override
	public boolean GoDown() {
     
        do
        {
        	Integer currentFloor = elevQ.peek();
        	  removeVisitingFloor();
        	  System.out.println("downwards");
        	  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }while(elevQ.size()>0);
        
        if (elevQ.size() > 0) {
        	Lift.setCurrenDirection(Direction.UP); 
        	GoUP();
        } else {
        	Lift.setCurrenDirection(Direction.NONE); 
        }
		return false;
        
	}

	@Override
	public void processRequest(int level) {
		
	}

	@Override
	public void startLift() {

	Lift.setCurrenDirection(getDirection());

		if (Lift.getCurrenDirection().equals(Direction.UP)) {
	            GoUP();
	        } else if (Lift.getCurrenDirection().equals(Direction.DOWN)) {
	            GoDown();
	        }
		
		
	}

	@Override
	public Direction getDirection() {
		        if (elevQ.size() > 0) return Direction.UP;
		        else if (elevQ.size() > 0) return Direction.DOWN;
		        else return Direction.NONE;
		
	}

	@Override
	public void addLevel(int n) {
		
		System.out.println("adding elevQ");
		elevQ.add(n);
		
	}
	



}
