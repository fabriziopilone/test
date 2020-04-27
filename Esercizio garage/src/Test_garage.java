
public class Test_garage {
	public static void main (String [] args) {
		Garage garage = new Garage("Garage1");
		Macchina test_gpl = new Macchina ("normale", "gpl", "0123");
		Macchina panda = new Macchina ("normale", "benzina", "1234");
		Macchina lamborghini = new Macchina ("lusso", "benzina", "2345");
		Macchina jeep = new Macchina ("grande", "benzina", "3456");
		
		garage.inserisciMacchina(test_gpl);
		garage.inserisciMacchina(panda);
		garage.inserisciMacchina(lamborghini);
		garage.inserisciMacchina(jeep);
		garage.stampa();
		garage.affittaPosto("normale", "gpl");
		garage.affittaPosto("normale", "benzina");
	}

}
