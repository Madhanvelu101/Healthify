package com.madhan.appstart;

import java.util.Timer;

public class SchedulerMain {
	public static void main(String args[]) throws InterruptedException {

		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTaskWater st = new ScheduledTaskWater(); // Instantiate SheduledTask class
		SchduleTaskBlink sb=new SchduleTaskBlink();
		time.schedule(st, 26000, 100000); // Create Repetitively task for every 1 secs
		time.schedule(sb, 3000,50000);

		//for demo only.
		/*for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(2000);
			if (i == 5) {
				System.out.println("Application Terminates");
				//System.exit(0);
			}
		}*/
	}
}
