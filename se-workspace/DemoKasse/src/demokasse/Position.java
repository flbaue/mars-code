package demokasse;

public class Position {
	private Produkt produkt;
	private int menge;

	public Position(Produkt produkt, int menge) {
		this.produkt = produkt;
		this.menge = menge;
	}

	public String getProduktBeschreibung() {
		return produkt.getName();
	}

	public int getMenge() {
		return menge;
	}

	public int getPreis() {
		return menge * produkt.getPreis();
	}

}
