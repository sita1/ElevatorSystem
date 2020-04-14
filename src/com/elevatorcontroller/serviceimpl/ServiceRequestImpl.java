package com.elevatorcontroller.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import com.elevatorcontroller.Enum.Direction;
import com.elevatorcontroller.model.Lift;
import com.elevatorcontroller.service.ServiceRequest;

public class ServiceRequestImpl implements ServiceRequest {

	List<Integer> elevQ = new ArrayList<Integer>();
	
	 Integer currentFloor = 0;
	 Integer maxPerson = 0;
	 Integer capacity = 0;
	 public ServiceRequestImpl()
	 {
		 elevQ =  new ArrayList<Integer>();
		 currentFloor = 0;
		 maxPerson=10;
		 capacity = 0;
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
		return elevQ.get(0);
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
	public String GoUP() {
		do {
			currentFloor = elevQ.get(0);
			removeVisitingFloor();

			System.out.println("Lift Going up to floor :" + currentFloor);
			try {
				Thread.sleep(3000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (elevQ.size() > 0);

		if (elevQ.size() > 0) {
			if (currentFloor < elevQ.get(0)) {
				Lift.setCurrenDirection(Direction.UP);
				GoUP();
			} else {
				Lift.setCurrenDirection(Direction.DOWN);
				GoDown();
			}
		} else {
			if (Lift != null)
				Lift.setCurrenDirection(Direction.NONE);
		}

		return "Lift Going up to floor :" + currentFloor;

	}

	private void removeVisitingFloor() {
		elevQ.remove(0);
		
	}

	@Override
	public String GoDown() {
     
        do
        {
        	 currentFloor = elevQ.get(0);
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
		return "Lift Going down to floor :" + currentFloor;
        
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
				int c=0;
				do
				{
					System.out.println("Please insert floor :");
					Scanner sc = new Scanner(System.in);
					
				
					 c = sc.nextInt();
					if (c > 0 && c<8) {
						if(!elevQ.contains(c))
						elevQ.add(c);
						if(elevQ.size()>0 && elevQ.size()>3)
						{
							Collections.sort(elevQ);
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if (currentFloor > c)
								GoDown();
							else
								GoUP();
						}
					

					}
					else
					{
						System.out.println("Please Enter Floor Between 1 To 7");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					}while(c>0);
			}
		}, 0, 5000);

	}

	@Override
	public boolean canAddPerson() {
		
		if(capacity<maxPerson)
			return true;
		
		
		return false;
	}


	



}
