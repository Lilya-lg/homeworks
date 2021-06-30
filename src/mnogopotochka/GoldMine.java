package mnogopotochka;

public class GoldMine {
	public int qnt = 1000;
	private volatile boolean isEmpty = true;
	public synchronized void mine() {
		if(isEmpty==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.qnt -=3;
		setEmpty(true);
		notify();
		System.out.print(Thread.activeCount()-1);
		System.out.println(" "+ this.qnt);
	}
	public int  getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
