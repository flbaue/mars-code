/**
 * Florian Bauer
 * flbaue@posteo.de
 * 07.10.2013
 * MatrixImplCTest.java
 */
package de.fbaue.ad.aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Florian Bauer
 *
 */
public class MatrixImplCTest {

    /**
     * 
     */
    @Test
    public void initializeTest() {

	MatrixInterface matrix1 = new MatrixImplC(new double[][] { { 1, 1, 1 },
		{ 2, 2, 2 }, { 3, 3, 3 } });

	assertTrue(matrix1.getValue(0, 0) == 1);
	assertTrue(matrix1.getValue(1, 0) == 1);
	assertTrue(matrix1.getValue(2, 0) == 1);
	assertTrue(matrix1.getValue(0, 1) == 2);
	assertTrue(matrix1.getValue(1, 1) == 2);
	assertTrue(matrix1.getValue(2, 1) == 2);
	assertTrue(matrix1.getValue(0, 2) == 3);
	assertTrue(matrix1.getValue(1, 2) == 3);
	assertTrue(matrix1.getValue(2, 2) == 3);
    }

    /**
     * 
     */
    @Test
    public void addTest() {

	MatrixInterface matrix1 = new MatrixImplC(new double[][] { { 1, 1, 1 },
		{ 2, 2, 2 }, { 3, 3, 3 } });
	MatrixInterface matrix2 = new MatrixImplC(new double[][] {
		{ 1.4, 1.5, 1.6 }, { 2.4, 2.5, 2.6 }, { 3.4, 3.5, 3.6 } });

	matrix1.add(matrix2);

	assertTrue(matrix1.getValue(0, 0) == 2.4);
	assertTrue(matrix1.getValue(1, 0) == 2.5);
	assertTrue(matrix1.getValue(2, 0) == 2.6);
	assertTrue(matrix1.getValue(0, 1) == 4.4);
	assertTrue(matrix1.getValue(1, 1) == 4.5);
	assertTrue(matrix1.getValue(2, 1) == 4.6);
	assertTrue(matrix1.getValue(0, 2) == 6.4);
	assertTrue(matrix1.getValue(1, 2) == 6.5);
	assertTrue(matrix1.getValue(2, 2) == 6.6);
    }

    /**
     * 
     */
    @Test
    public void scalarMultiplicationTest() {

	MatrixInterface matrix1 = new MatrixImplC(new double[][] { { 1, 1, 1 },
		{ 2, 2, 2 }, { 3, 3, 3 } });
	double scalar = 2.5;

	matrix1.scalarMultiplication(scalar);

	assertTrue(matrix1.getValue(0, 0) == 2.5);
	assertTrue(matrix1.getValue(1, 0) == 2.5);
	assertTrue(matrix1.getValue(2, 0) == 2.5);
	assertTrue(matrix1.getValue(0, 1) == 5.0);
	assertTrue(matrix1.getValue(1, 1) == 5.0);
	assertTrue(matrix1.getValue(2, 1) == 5.0);
	assertTrue(matrix1.getValue(0, 2) == 7.5);
	assertTrue(matrix1.getValue(1, 2) == 7.5);
	assertTrue(matrix1.getValue(2, 2) == 7.5);
    }

    /**
     * 
     */
    @Test
    public void matrixMultiplicationTest() {
	MatrixInterface matrix1 = new MatrixImplC(new double[][] { { 1, 1, 1 },
		{ 2, 2, 2 }, { 3, 3, 3 } });
	MatrixInterface matrix2 = new MatrixImplC(new double[][] {
		{ 1.4, 1.5, 1.6 }, { 2.4, 2.5, 2.6 }, { 3.4, 3.5, 3.6 } });

	matrix1.matrixMultiplication(matrix2);

	assertTrue(matrix1.getValue(0, 0) == 1.4);
	assertTrue(matrix1.getValue(1, 0) == 2.4);
	assertTrue(matrix1.getValue(2, 0) == 3.4);
	assertTrue(matrix1.getValue(0, 1) == 3.0);
	assertTrue(matrix1.getValue(1, 1) == 5.0);
	assertTrue(matrix1.getValue(2, 1) == 7.0);
	assertTrue(Math.round(matrix1.getValue(0, 2) * 10) / 10.0 == 4.8);
	assertTrue(Math.round(matrix1.getValue(1, 2) * 10) / 10.0 == 7.8);
	assertTrue(Math.round(matrix1.getValue(2, 2) * 10) / 10.0 == 10.8);
    }

    /**
     * 
     */
    @Test
    public void powTest() {

	MatrixInterface matrix1 = new MatrixImplC(new double[][] { { 1, 1, 1 },
		{ 2, 2, 2 }, { 3, 3, 3 } });
	int pow = 3;

	matrix1.pow(pow);

	assertTrue(matrix1.getValue(0, 0) == 1.0);
	assertTrue(matrix1.getValue(1, 0) == 4.0);
	assertTrue(matrix1.getValue(2, 0) == 9.0);
	assertTrue(matrix1.getValue(0, 1) == 2.0);
	assertTrue(matrix1.getValue(1, 1) == 8.0);
	assertTrue(matrix1.getValue(2, 1) == 18.0);
	assertTrue(matrix1.getValue(0, 2) == 3.0);
	assertTrue(matrix1.getValue(1, 2) == 12.0);
	assertTrue(matrix1.getValue(2, 2) == 27.0);
    }
    
    /**
     * 
     */
    @Test
    public void randomTest() {
	MatrixInterface matrix1 = new MatrixImplC(MatrixGeneratorUtil.randomMatrix(2000, 0, 10, 5));
	MatrixInterface matrix2 = new MatrixImplC(MatrixGeneratorUtil.randomMatrix(2000, 0, 10, 5));
	matrix1.matrixMultiplication(matrix2);
    }

}
