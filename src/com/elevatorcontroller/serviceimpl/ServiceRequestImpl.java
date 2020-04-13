package com.elevatorcontroller.serviceimpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import com.elevatorcontroller.Enum.Direction;
import com.elevatorcontroller.model.Lift;
import com.elevatorcontroller.service.ServiceRequest;

public class ServiceRequestImpl implements ServiceRequest {

	Queue<Integer> elevQ = new LinkedList<Integer>();
	
	 Integer currentFloor = 0;
	 public ServiceRequestImpl()
	 {
		 elevQ = new LinkedList<Integer>();
		 currentFloor = 0;
	 }
	 
	@Inject
	Lift Lift;

	@Override
	public void SetLevel(int level) {
		elevQ.add(level);
	}

	@Override
	public int GetLevel() {
		if(elevQ.size()>0)
		return elevQ.peek();
		else
			return 0;
		
	}

	public boolean CanAddLevel(int level) {
		if (currentFloor < level)
			return true;
		else if (currentFloor > level)
			return true;
		return false;
	}

	@Override
	public boolean GoUP() {
		  do {
			  currentFloor = elevQ.peek();
			  removeVisitingFloor();
			 
			 System.out.println("Lift Going up to floor :" + currentFloor);
			 try {
				Thread.sleep(3000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		  }while(elevQ.size()>0);
		  
		    
	        if (elevQ.size() > 0) {
	        	if(currentFloor<elevQ.peek())
	        	{
	        	Lift.setCurrenDirection(Direction.UP);
	        	GoUP();
	        	}
	        	else
	        	{
	        		Lift.setCurrenDirection(Direction.DOWN);
	        	GoDown();
	        	}
	        } else {
	        	if(Lift!=null)
	        	Lift.setCurrenDirection(Direction.NONE); 
	        }
	   
			return false;
		  
		  
	}

	private void removeVisitingFloor() {
		elevQ.poll();
		
	}

	@Override
	public boolean GoDown() {
     
        do
        {
        	 currentFloor = elevQ.peek();
        	  removeVisitingFloor();
        	  System.out.println("Lift Going down to floor :" + currentFloor);
        	  try {
				Thread.sleep(3000);
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
		if(CanAddLevel(level))
		SetLevel(level);
		
	}



	@Override
	public Direction getDirection() {
		        if (elevQ.size() > 0) return Lift.getCurrenDirection();
		        else return Direction.NONE;
		
	}

	@Override
	public void inputEveryFiveSecond() {

		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				while (true) {
					System.out.println("Please insert floor");
					Scanner sc = new Scanner(System.in);
					int c = sc.nextInt();
					if (c > 0) {
						elevQ.add(c);
						if (currentFloor > c)
							GoDown();
						else
							GoUP();

					}
				}
			}
		}, 0, 5000);

	}


	



}
