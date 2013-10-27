package de.fbaue.ad.aufgabe3_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowTest {

    @Test
    public void pow1Test() {
	StepCounter counter = new StepCounter();
	double result = Pow.pow1(2, 1000, counter);
	System.out.println(result +" took " + counter.getSteps() + " steps");
    }
    
    @Test
    public void pow2Test() {
	StepCounter counter = new StepCounter();
	double result = Pow.pow2(2, 1000, counter);
	System.out.println(result +" took " + counter.getSteps() + " steps");
    }
    
    @Test
    public void pow3Test() {
	StepCounter counter = new StepCounter();
	double result = Pow.pow3(2, 1000, counter);
	System.out.println(result +" took " + counter.getSteps() + " steps");
    }

}
