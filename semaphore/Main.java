package semaphore;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
   // Exchanger<Cart> exLT = new Exchanger<Cart>();
	// Exchanger<Cart> exTU =  new Exchanger<Cart>();
	//Cart cart = new Cart(MoneyHeap heap);
	Semaphore semaphore1 = new Semaphore(1);
	Semaphore semaphore2 = new Semaphore(0);
	Semaphore semaphore3 = new Semaphore(0);
	MoneyHeap heap = new MoneyHeap(20);
	Cart cart = new Cart(heap);
	new Loader(cart,semaphore1,semaphore2);
	new Transporter(semaphore2,semaphore3,semaphore1,cart);
	new Unloader(semaphore3,semaphore2,cart);
	}
}
