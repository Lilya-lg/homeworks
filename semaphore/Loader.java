package semaphore;


import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable{
	private MoneyHeap heap;
	private Cart cart;
	private Semaphore semaphore1;
	private Semaphore semaphore2;
	public Loader(Cart cart, Semaphore semaphore1,Semaphore semaphore2) {
		new Thread(this).start();
		this.cart = cart;
		this.semaphore1 = semaphore1;
		this.semaphore2 = semaphore2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(cart.getRemainder()>0) {
		try {
			semaphore1.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
				System.out.println("Loader start");	
				try {
					cart.loadFromHeap();
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Loader end");
				System.out.println("Now in heap " + cart.getRemainder());
				System.out.println("Now in cart " + cart.getAmount());
				System.out.println("Loader waiting...");
				semaphore1.release(0);
				semaphore2.release();
			}
			
	}
	

}
