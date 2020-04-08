package com.elevatorcontroller.application;

import java.util.Scanner;
import java.util.TreeSet;

import com.elevatorcontroller.module.AppModule;
import com.elevatorcontroller.processRequests.FormatRquests;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApplication {
	public static void main(String ab[])
	{
		Injector injector = Guice.createInjector(new AppModule());
		
		
		   Scanner scan = new Scanner(System.in);
		   Integer n = scan.nextInt(); 
		
	    FormatRquests formatRquests =injector.getInstance(FormatRquests.class);
	    //formatRquests.makeRequestProcess(upward,userInputs);
	}



}
