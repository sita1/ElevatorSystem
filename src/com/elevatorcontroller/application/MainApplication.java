package com.elevatorcontroller.application;

import java.util.TreeSet;

import com.elevatorcontroller.module.AppModule;
import com.elevatorcontroller.processRequests.FormatRquests;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApplication {
	public static void main(String ab[])
	{
		Injector injector = Guice.createInjector(new AppModule());
		TreeSet<Integer> userInputs = new TreeSet<Integer>();
	    FormatRquests formatRquests =injector.getInstance(FormatRquests.class);
	}

}
