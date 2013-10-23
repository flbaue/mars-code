package demokasse;

public class Kasse {
	
	public void neueVerkaufsposition(Verkauf vk, String produkt, int menge) {
		vk.addPosition(findeProdukt(produkt), menge);
	}
	
	public int getGesamtpreis(Verkauf vk){
		return vk.getGesamtpreis();
	}
	
	private Produkt findeProdukt(String productName) {
		return new Produkt(productName, 5);
	}

}
