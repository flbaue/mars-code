import java.util.*;

public class GameHelper {

	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

	private int rasterLänge = 4;
	private int rasterGröße = rasterLänge * rasterLänge;
	private int[] raster = new int[rasterGröße];
	
	private int schiffeAnzahl = 0;
	
	public ArrayList<String> platziereSchiff(int schiffGröße) {
	
		ArrayList<String> alphaZellen = new ArrayList<String>(); // Ergebnis z.B. a6,b6,...
		int[] koordinaten = new int[schiffGröße]; // aktuelle kandidaten
		int versuche = 0;
		int ort = 0;
		boolean erfolg = false;
		
		// ungrade schiffe werden senkrecht gesetzt
		int increment = 1;
		if((schiffeAnzahl % 2) == 1) {
			incement = rasterLänge;
		}
		
		while(!erfolg & versuche++ < 200) {
		
			ort = (int) (Math.random() * rasterGröße)
			
			erfolg = true;
			int x = 0;
			while(erfolg && x < schiffGröße) {
			
				if(raster[ort] == 0) {
					koordinaten[x++] = ort;
					ort += incement;
					if(ort >= rasterGröße) {
						erfolg = false;
					}
					
				}
			
			}
		
		}
			
	}

}