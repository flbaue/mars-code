package demokasse;

import static org.junit.Assert.*;

import org.junit.Test;

public class KasseTest {

	@Test
	public void test() {
		Kasse k = new Kasse();
		Verkauf v = new Verkauf();
		
		k.neueVerkaufsposition(v, "TestProdukt1", 2);
		k.neueVerkaufsposition(v, "TestProdukt2", 3);
		
		assertTrue(k.getGesamtpreis(v) == 25);
	}

}
