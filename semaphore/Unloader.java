package semaphore;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable{
	private MoneyHeap heap;
	private Cart cart;
//	private Exchanger<Cart> exTU;
	//private Cart cart;
	private Semaphore semaphore3;
	private Semaphore semaphore2;
	public Unloader(Semaphore semaphore3,Semaphore semaphore2,Cart cart) {
		//this.exTU = exTU;
		this.cart = cart;
		this.semaphore3 = semaphore3;
		this.semaphore2 = semaphore2;
		new Thread(this).start();
	}
	@Override
	public void run() {
		while(cart.getRemainder()>0) {
			try {
				semaphore3.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
				System.out.println("Unloader start");
				try {
					//this.cart = cart;
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Unloader end");
				this.cart.setAmount(0);
				semaphore3.release(0);
				semaphore2.release();
				//System.out.println("Now in heap " + cart.getRemainder());
				System.out.println("Now in cart ul" + cart.getAmount());
			
		
		}
		
	}

}
