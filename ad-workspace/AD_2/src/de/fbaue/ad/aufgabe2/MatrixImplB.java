/**
 * Florian Bauer
 * flbaue@posteo.de
 * 06.10.2013
 * MatrixImplB.java
 */
package de.fbaue.ad.aufgabe2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixImplB implements MatrixInterface {

    List<ElementVO>[] values;

    /**
     * @param matrix
     */
    public MatrixImplB(final double[][] matrix) {
	initialize(matrix);
    }

    /**
     * {@inheritDoc }
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initialize(final double[][] matrix) {
	this.values = new List[matrix.length];
	for (int y = 0; y < matrix.length; y++) {
	    this.values[y] = new ArrayList<ElementVO>();
	    for (int x = 0; x < matrix.length; x++) {
		if (matrix[y][x] != 0) {
		    setValue(matrix[y][x], x, y);
		}
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void add(final MatrixInterface matrix) {
	for (int y = 0; y < values.length; y++) {
	    for (int x = 0; x < values.length; x++) {
		double sum = getValue(x, y) + matrix.getValue(x, y);
		setValue(sum, x, y);
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void scalarMultiplication(final double scalar) {
	for (int y = 0; y < values.length; y++) {
	    for (int x = 0; x < values.length; x++) {
		double sum = getValue(x, y) * scalar;
		setValue(sum, x, y);
	    }
	}

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void matrixMultiplication(final MatrixInterface matrix) {
	for (int y = 0; y < values.length; y++) {
	    for (int x = 0; x < values.length; x++) {
		double sum = getValue(x, y) * matrix.getValue(y, x);
		setValue(sum, x, y);
	    }
	}

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void pow(final int b) {
	MatrixInterface m = clone();
	for (int i = 1; i < b; i++) {
	    matrixMultiplication(m);
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public double getValue(final int x, final int y) {
	double result = 0;
	for (ElementVO element : values[y]) {
	    if (element.x == x) {
		result = element.value;
	    }
	}
	return result;
    }

    /**
     * @param value
     * @param x
     * @param y
     * @param sort
     */
    private void setValue(final double value, final int x, final int y) {

	Iterator<ElementVO> iterator = values[y].iterator();
	while (iterator.hasNext()) {
	    ElementVO element = iterator.next();
	    if (element.x == x) {
		iterator.remove();
		break;
	    }
	}
	if (value != 0) {
	    values[y].add(new ElementVO(value, x));
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public MatrixInterface clone() {
	int length = values.length;
	double[][] matrix = new double[length][length];
	for (int y = 0; y < length; y++) {
	    for (int x = 0; x < length; x++) {
		matrix[y][x] = getValue(x, y);
	    }
	}
	return new MatrixImplB(matrix);
    }

    /**
     * @author Florian Bauer
     * 
     */
    private class ElementVO implements Comparable<ElementVO> {
	private final double value;
	private final int x;

	/**
	 * @param value
	 * @param x
	 */
	private ElementVO(double value, int x) {
	    this.value = value;
	    this.x = x;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public int compareTo(ElementVO o) {
	    if (x < o.x) {
		return -1;
	    }
	    if (x > o.x) {
		return 1;
	    }
	    return 0;
	}
    }

}
