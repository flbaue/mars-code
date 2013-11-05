/**
 * Investment.java
 * Florian Bauer
 * flbaue@posteo.de
 * 29.10.2013
 */
package aufgabe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florian Bauer
 * 
 */
public class Investment {

    /**
     * 
     */
    public Investment() {
	List<Integer> kurse = new ArrayList<Integer>();
	kurse.add(5);
	kurse.add(1);
	kurse.add(5);
	kurse.add(6);
	kurse.add(0);
	kurse.add(2);

	List<Steigung> steigungen = findeSteigung(kurse);
	findeMaxSteigung(steigungen);
	System.out.println(steigungen);
	
	//TODO maximale teilsumme aus den differenzen von auf und absteigungen

    }

    /**
     * @param steigungen
     */
    private void findeMaxSteigung(List<Steigung> steigungen) {
	// TODO Auto-generated method stub
	
    }

    List<Steigung> findeSteigung(List<Integer> kurse) {
	KursElem low = new KursElem(0, kurse.get(0));
	KursElem high = new KursElem(0, kurse.get(0));
	int pos = 0;
	boolean raise = false;
	List<Steigung> steigungen = new ArrayList<Steigung>();

	for (Integer kurs : kurse) {
	    if (kurs < low.value) {
		if (raise == true)
		    steigungen.add(new Steigung(low.pos, low.value, high.pos, high.value));
		raise = false;
		low.value = kurs;
		low.pos = pos;

	    }
	    if (kurs > low.value) {
		high.value = kurs;
		high.pos = pos;
		raise = true;
		if (pos == kurse.size() - 1)
		    steigungen.add(new Steigung(low.pos, low.value, high.pos, high.value));

	    }
	    pos++;
	}
	return steigungen;
    }

    private class KursElem {
	int pos;
	int value;

	private KursElem(int pos, int value) {
	    this.pos = pos;
	    this.value = value;
	}
    }

    private class Steigung {
	int lowPos;
	int highPos;
	int lowVal;
	int highVal;

	Steigung(int lowPos, int lowVal, int highPos, int highVal) {
	    this.lowPos = lowPos;
	    this.highPos = highPos;
	    this.lowVal = lowVal;
	    this.highVal = highVal;
	}
    }

}
