/**
 * Florian Bauer
 * flbaue@posteo.de
 * 06.10.2013
 * MatrixImplA.java
 */
package de.fbaue.ad.aufgabe2;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixImplA implements MatrixInterface {

    private int rowLength;
    private double[] values;

    /**
     * @param values
     */
    public MatrixImplA(final double[][] values) {
	initialize(values);
    }

    /**
     * @param values
     * @param rowLength
     */
    public MatrixImplA(final double[] values, final int rowLength) {
	this.values = values;
	this.rowLength = rowLength;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void initialize(final double[][] values) {
	this.rowLength = values.length;
	int numberOfElements = rowLength * rowLength;
	this.values = new double[numberOfElements];
	for (int pos = 0; pos < numberOfElements; pos++) {
	    int x = pos % rowLength;
	    int y = pos / rowLength;
	    this.values[pos] = values[y][x];
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void add(final MatrixInterface matrix) {
	for (int pos = 0; pos < values.length; pos++) {
	    int x = pos % rowLength;
	    int y = pos / rowLength;
	    values[pos] = values[pos] + matrix.getValue(x, y);
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void scalarMultiplication(final double scalar) {
	for (int pos = 0; pos < values.length; pos++) {
	    values[pos] = values[pos] * scalar;
	}

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void matrixMultiplication(final MatrixInterface matrix) {
	for (int pos = 0; pos < values.length; pos++) {
	    int x = pos / rowLength;
	    int y = pos % rowLength;
	    values[pos] = values[pos] * matrix.getValue(x, y);
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void pow(final int b) {
	MatrixInterface m = new MatrixImplA(values.clone(), rowLength);
	for (int i = 1; i < b; i++) {
	    matrixMultiplication(m);
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public double getValue(final int x, final int y) {
	int pos = x + (y * rowLength);
	return values[pos];
    }
}
