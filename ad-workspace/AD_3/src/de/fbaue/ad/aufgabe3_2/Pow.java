package de.fbaue.ad.aufgabe3_2;

public class Pow {

    public static double pow1(double x, double k, StepCounter counter) {
	double r = 1;
	for (int i = 0; i < k; i++) {
	    r = r * x;
	    counter.step();
	}
	return r;
    }

    public static double pow2(double x, double k, StepCounter counter) {
	if (k == 0) {
	    return 1;
	} else if ((k % 2) == 0) {
	    double t = pow1(x, k / 2, counter);
	    return pow1(t, 2, counter);
	} else {
	    double t = pow1(x, (k - 1) / 2, counter);
	    return pow1(t, 2, counter) * x;
	}

    }
    
    public static double pow3(double x, double k, StepCounter counter) {
	if (k == 0) {
	    return 1;
	} else if ((k % 2) == 0) {
	    double t = pow3(x, k / 2, counter);
	    counter.step();
	    return t * t;
	} else {
	    double t = pow3(x, (k - 1) / 2, counter);
	    counter.step();
	    counter.step();
	    return t * t * x;
	}
    }
}
