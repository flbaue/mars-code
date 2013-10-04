public class BierLied {

	public static void main(String[] args) {
	
		int bierAnzahl = 99;
		String wort = "Flaschen";
		String wort2 = "sind";
		
		while (bierAnzahl > 0) {
			
			
			System.out.println(bierAnzahl + " " + wort + " Bier im Kühlschrank");
			System.out.println(bierAnzahl + " " + wort + " Bier");
			System.out.println("Hol eine raus");
			System.out.println("Und lass sie rumgehen");
			bierAnzahl = bierAnzahl - 1;

			if (bierAnzahl == 1){
				wort = "Flasche";
				wort2 = "ist";
			}

			
			if(bierAnzahl > 0) {
				System.out.println("Jetzt " + wort2  +  " noch " + bierAnzahl + " " + 
					wort + " Bier im Kühlschrank");
			} else {
				System.out.println("Jetzt ist kein Bier mehr im Kühlschrank");
			}
		
		}
	
	}


}
