package demokasse;

public class Produkt {

	private String name;
	private int preis;
	
	public Produkt(String produktName, int preis) {
		this.name = produktName;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return preis;
	}

}
