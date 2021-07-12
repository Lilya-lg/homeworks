package semaphore;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable{
	private Cart cart;
	//private Exchanger<Cart> exLT;
	//private Exchanger<Cart> exTU;
	private MoneyHeap heap;
	private Semaphore semaphore2;
	private Semaphore semaphore3;
	private Semaphore semaphore1;
   public Transporter(Semaphore semaphore2,Semaphore semaphore3,Semaphore semaphore1,Cart cart) { 
	  //this.exLT = exLT;
	  //this.exTU = exTU;
	   this.semaphore2 = semaphore2;
	   this.semaphore1 = semaphore1;
	   this.semaphore3 = semaphore3;
	  this.cart = cart;
	  new Thread(this).start(); 
   }
	@Override 
	public void run() {
		while(cart.getRemainder()>0) {
			try {
				semaphore2.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(this.cart.getAmount()>0) {
				System.out.println("Transpoter start");
				try {
					//this.cart = cart; 
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Transpoter end");
				System.out.println("Transpoter waiting");
				System.out.println("Now in heap tr " + cart.getRemainder());
				System.out.println("Now in cart tr " + cart.getAmount());
				semaphore2.release(0);
				semaphore3.release();
				}
			else {
				System.out.println("Transpoter start");
				try {
					//this.cart.setAmount(0);; 
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Transpoter end");
				semaphore2.release(0);
				semaphore1.release();
			}
				
				//System.out.println("Transpoter start");
				//try {
					//TimeUnit.SECONDS.sleep(5);
				//} catch (InterruptedException e) {
					//e.printStackTrace();
			//	}
				//System.out.println("Transpoter end");
				
				
				
				
			
			
		}
		
	}

}
