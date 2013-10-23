/**
 * MessreiheModul.java
 * Florian Bauer
 * flbaue@posteo.de
 * 15.10.2013
 */
package fbaue.ad.messreihe;

import java.util.List;

/**
 * @author Florian Bauer
 * 
 */
public class MessreiheModul1 {

    public double mittelwert(final List<Double> werte) {
	double sum = 0;
	final int n = werte.size();
	for (Double wert : werte) {
	    sum += wert;
	}
	return (1.0 / n) * sum;
    }

    public double varianz(final List<Double> werte) {
	double sum = 0;
	final double avg = mittelwert(werte);
	final double factor = 1.0 / (werte.size() - 1);
	for (Double wert : werte) {
	    sum += Math.pow((wert - avg), 2);
	}
	return Math.sqrt(factor * sum);
    }
    
    
}
