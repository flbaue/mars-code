/**
 * RefCounter.java
 * Florian Bauer
 * flbaue@posteo.de
 * 26.10.2013
 */
package fbaue.ad.liste;

/**
 * @author Florian Bauer
 * 
 */
public class RefCounter {
    private int steps;

    public RefCounter() {
	steps = 0;
    }

    public void step() {
	steps++;
    }

    public int getSteps() {
	return steps;
    }
    
    public void reset() {
	steps = 0;
    }
}
