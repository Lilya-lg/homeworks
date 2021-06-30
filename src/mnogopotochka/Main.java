package mnogopotochka;

public class Main {
	public static void main(String[] args) {
	GoldMine goldmine = new GoldMine();
	System.out.println("start");
	Pizant pizant1 = new Pizant(goldmine,"1");
	Pizant pizant2 = new Pizant(goldmine,"2");
	Pizant pizant3 = new Pizant(goldmine,"3");
	new Baraka(goldmine);
	}
}
