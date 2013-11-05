/**
 * RefCounter.java
 * Florian Bauer
 * flbaue@posteo.de
 * 26.10.2013
 */
package counter;

/**
 * @author Florian Bauer
 * 
 */
public class StepCounter {
    private int steps;

    public StepCounter() {
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
