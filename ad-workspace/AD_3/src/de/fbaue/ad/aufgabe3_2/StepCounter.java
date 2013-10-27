package de.fbaue.ad.aufgabe3_2;

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

}
