/**
 * Florian Bauer
 * flbaue@posteo.de
 * 06.10.2013
 * MatrixImplATest.java
 */
package de.fbaue.ad.aufgabe2;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixImplATest {

    private MatrixInterface matrixA1;
    private MatrixInterface matrixA2;
    private MatrixInterface matrixB1;
    private MatrixInterface matrixB2;
    private MatrixInterface matrixC1;
    private MatrixInterface matrixC2;
    double[][] valuesA;
    double[][] valuesB;
    double[][] valuesC;
    int n = 3;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

	valuesA = MatrixGeneratorUtil.randomMatrix(n, 0, 10, 90);
	matrixA1 = new MatrixImplA(valuesA);
	matrixA2 = new MatrixImplA(valuesA);
	valuesB = MatrixGeneratorUtil.randomMatrix(n, 0, 10, 90);
	matrixB1 = new MatrixImplA(valuesB);
	matrixB2 = new MatrixImplA(valuesB);
	valuesC = MatrixGeneratorUtil.randomMatrix(n, 0, 10, 90);
	matrixC1 = new MatrixImplA(valuesC);
	matrixC2 = new MatrixImplA(valuesC);
    }

    /**
     * 
     */
    @Test
    public void initializeTest() {

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		assertTrue(valuesA[y][x] == matrixA1.getValue(x, y));
	    }
	}
    }

    /**
     * 
     */
    @Test
    public void addTest() {

	matrixA1.add(matrixB1);
	matrixA1.add(matrixC1);
	MatrixInterface m1 = matrixA1;

	matrixB2.add(matrixC2);
	matrixB2.add(matrixA2);
	MatrixInterface m2 = matrixB2;

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		double v1 = round(m1.getValue(x, y), 2);
		double v2 = round(m2.getValue(x, y), 2);
		// System.out.println("m1=" + v1 + " m2=" + v2);
		assertTrue(v1 == v2);
	    }
	}
    }

    /**
     * 
     */
    @Test
    public void scalarMultiplicationTest() {

	double scalar = 1;

	matrixA1.scalarMultiplication(scalar);

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		assertTrue(matrixA2.getValue(x, y) == matrixA1.getValue(x, y));
	    }
	}

	scalar = 2.5;

	matrixA1.scalarMultiplication(scalar);
	matrixA2.scalarMultiplication(scalar);

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		assertTrue(matrixA2.getValue(x, y) == matrixA1.getValue(x, y));
	    }
	}

    }

    /**
     * 
     */
    @Test
    public void matrixMultiplicationTest() {

	matrixA1.matrixMultiplication(matrixA2);
	matrixA2.pow(2);

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		double v1 = round(matrixA1.getValue(x, y), 2);
		double v2 = round(matrixA2.getValue(x, y), 2);
		// System.out.println("m1=" + v1 + " m2=" + v2);
		assertTrue(v1 == v2);
	    }
	}

    }

    /**
     * 
     */
    @Test
    public void powTest() {

	int pow = 3;

	matrixA1.pow(pow);
	matrixA2.pow(pow);

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		double v1 = round(matrixA1.getValue(x, y), 2);
		double v2 = round(matrixA2.getValue(x, y), 2);
		// System.out.println("m1=" + v1 + " m2=" + v2);
		assertTrue(v1 == v2);
	    }
	}
    }

    /**
     * 
     */
    @Test
    public void stressTest() {
	MatrixInterface matrix1 = new MatrixImplA(
		MatrixGeneratorUtil.randomMatrix(2000, 0, 10, 5));
	MatrixInterface matrix2 = new MatrixImplA(
		MatrixGeneratorUtil.randomMatrix(2000, 0, 10, 5));
	matrix1.matrixMultiplication(matrix2);
    }

    private double round(double value, int decimal) {
	int fact = 1;
	for (int i = 0; i < decimal; i++) {
	    fact *= 10;
	}
	return ((int) (value * fact)) / (fact * 1.0);
    }
}
