package Racers;

import java.util.concurrent.CountDownLatch;

public class Racer implements Runnable{
	private CountDownLatch countDownLatch;
	private String name;
	public static String winnerName = "";
	public Racer(String name,CountDownLatch countDownLatch) {
		this.name = name;
		this.countDownLatch = countDownLatch;
		new Thread(this).start();
	}
	
	public static String getWinnerName() {
		return winnerName;
	}

	public static void setWinnerName(String winnerName) {
		Racer.winnerName = winnerName;
	}

	@Override
	public void run() {
		int length = 0;
		while(length<20) {
			length += (int)(Math.random()*4);
			String way = "";
			for (int i = 0; i < length; i++) {
				way+= "_";
				
			}
			System.out.println(name + ": "+ way);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(winnerName =="") {
			setWinnerName(name);
		}
			
			
		countDownLatch.countDown();
	}
	
} 

