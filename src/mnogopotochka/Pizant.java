package mnogopotochka;

public class Pizant extends Thread{
	private GoldMine goldMine;
	private String name;
	public Pizant(GoldMine goldMine,String name) {
		start();
		this.name = name;
		this.goldMine = goldMine;
	}
	@Override
	public void run() {
		while(goldMine.getQnt()<=1000 && goldMine.getQnt()>0) {
			
			goldMine.mine();
			//System.out.println(this.name + goldMine.getQnt());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}
}
