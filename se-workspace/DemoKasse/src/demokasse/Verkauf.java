package demokasse;

import java.util.ArrayList;
import java.util.List;

public class Verkauf {
	List<Position> vkp = new ArrayList<Position>();

	public void addPosition(Produkt produkt, int menge) {
		vkp.add(new Position(produkt, menge));
	}

	public int getGesamtpreis() {
		int summe = 0;
		for (Position pos : vkp) {
			summe += pos.getPreis();
		}
		return summe;
	}

}
