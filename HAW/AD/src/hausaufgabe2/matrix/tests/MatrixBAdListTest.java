/*
 * Florian Bauer
 * flbaue@posteo.de
 * 2013
 */

/**
 * Florian Bauer
 * flbaue@posteo.de
 * 06.10.2013
 * MatrixImplATest.java
 */
package hausaufgabe2.matrix.tests;

import hausaufgabe2.matrix.Matrix;
import hausaufgabe2.matrix.MatrixBAdList;
import hausaufgabe2.matrix.MatrixGeneratorUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Florian Bauer
 */
public class MatrixBAdListTest {

    private Matrix matrixA1;
    private Matrix matrixA2;
    private Matrix matrixB1;
    private Matrix matrixB2;
    private Matrix matrixC1;
    private Matrix matrixC2;
    double[][] valuesA;
    double[][] valuesB;
    double[][] valuesC;
    int n = 3;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        valuesA = MatrixGeneratorUtil.randomMatrix(n, 90);
        matrixA1 = new MatrixBAdList(valuesA);
        matrixA2 = new MatrixBAdList(valuesA);
        valuesB = MatrixGeneratorUtil.randomMatrix(n, 90);
        matrixB1 = new MatrixBAdList(valuesB);
        matrixB2 = new MatrixBAdList(valuesB);
        valuesC = MatrixGeneratorUtil.randomMatrix(n, 90);
        matrixC1 = new MatrixBAdList(valuesC);
        matrixC2 = new MatrixBAdList(valuesC);
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

        matrixA1 = matrixA1.add(matrixB1);
        matrixA1 = matrixA1.add(matrixC1);
        Matrix m1 = matrixA1;

        matrixB2 = matrixB2.add(matrixC2);
        matrixB2 = matrixB2.add(matrixA2);
        Matrix m2 = matrixB2;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                double v1 = round(m1.getValue(x, y), 2);
                double v2 = round(m2.getValue(x, y), 2);
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

        matrixA1 = matrixA1.scalarMulti(scalar);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                assertTrue(matrixA2.getValue(x, y) == matrixA1.getValue(x, y));
            }
        }

        scalar = 2.5;

        matrixA1 = matrixA1.scalarMulti(scalar);
        matrixA2 = matrixA2.scalarMulti(scalar);

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

        matrixA1 = matrixA1.matrixMulti(matrixA1);
        matrixA2 = matrixA2.pow(2);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                double v1 = round(matrixA1.getValue(x, y), 2);
                double v2 = round(matrixA2.getValue(x, y), 2);
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

        matrixA1 = matrixA1.pow(pow);
        matrixA2 = matrixA2.pow(pow);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                double v1 = round(matrixA1.getValue(x, y), 2);
                double v2 = round(matrixA2.getValue(x, y), 2);
                assertTrue(v1 == v2);
            }
        }
    }

    private double round(double value, int decimal) {
        int fact = 1;
        for (int i = 0; i < decimal; i++) {
            fact *= 10;
        }
        return ((int) (value * fact)) / (fact * 1.0);
    }
}