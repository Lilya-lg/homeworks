package Racers;

import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String[] args) throws InterruptedException {
	CountDownLatch cdl = new CountDownLatch(2);
	Racer racer1 = new Racer("First",cdl);
	Racer racer2 = new Racer("Second",cdl);
	/*
    while(racer1.isAlive() && racer2.isAlive()) {
    }
    if(racer1.isAlive()) {
	    System.out.println("Second");
	}
    else {
    	System.out.println("First");	
    }
    */
	try {
		cdl.await();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	System.out.println("Winner" + " " + Racer.winnerName);
	}
}
