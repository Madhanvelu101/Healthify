package com.madhan.appstart;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SchduleTaskBlink extends TimerTask {
	Date now;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		now = new Date(); // initialize date
		System.out.println("Starting the Blink scheduler Time is :" + now); // Display current time
		CircleSplashScreen.getInstance("Blink");
	}

}
