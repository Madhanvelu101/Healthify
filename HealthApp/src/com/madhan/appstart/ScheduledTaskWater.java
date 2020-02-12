package com.madhan.appstart;

import java.util.Date;
import java.util.TimerTask;

//Create a class extends with TimerTask
public class ScheduledTaskWater extends TimerTask {

	Date now; // to display current time

	// Add your task here"
	public void run() {
		now = new Date(); // initialize date
		System.out.println("Starting the water scheduler Time is :" + now); // Display current time
		 CircleSplashScreen.getInstance("Water");
	}
}