package com.elevatorcontroller.application;

import com.elevatorcontroller.module.AppModule;
import com.elevatorcontroller.processRequests.FormatRquests;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApplication {
	public static void main(String ab[])
	{
		Injector injector = Guice.createInjector(new AppModule());
	    FormatRquests formatRquests =injector.getInstance(FormatRquests.class);
	    //formatRquests.makeRequestProcess(upward,userInputs);
	    formatRquests.processRequest();
	}



}
