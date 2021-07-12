package semaphore;

import java.util.concurrent.Semaphore;

public class Cart {
	private MoneyHeap heap;
	private int amount;
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private int remainder;
	public int getRemainder() {
		return remainder;
	}
	public int getAmount() {
		return amount;
	}
	//private Semaphore semaphore1;
	//private Semaphore semaphore2;
	//private int cartAmount;
	public Cart(MoneyHeap heap){
		this.remainder = heap.getAmount();
		this.amount = 0;
	}
	public void loadFromHeap() {
		if(this.remainder>=6) {
		this.remainder = this.remainder-6;
		this.amount = 6;
		}
		else {
		
			this.amount = remainder;
			this.remainder = 0;
		}
	}
	
	
}
