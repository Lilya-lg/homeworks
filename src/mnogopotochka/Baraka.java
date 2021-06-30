package mnogopotochka;

public class Baraka {
	private GoldMine goldMine;
	private Pizant pizant;
	public Baraka(GoldMine goldMine)  {
		this.goldMine = goldMine;
		createPeasant();
	}
	public void createPeasant() {
		int temp = 4;
		while(goldMine.getQnt()<=1000 && goldMine.getQnt()>0 ) {
		try {
			new Pizant(goldMine,Integer.toString(temp++));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
