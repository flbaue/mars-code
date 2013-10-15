/**
 * Florian Bauer
 * flbaue@posteo.de
 * 07.10.2013
 * MatrixImplC.java
 */
package de.fbaue.ad.aufgabe2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixImplCSet implements MatrixInterface {

    private Set<ElementVO> values;
    private int rowLength;

    /**
     * @param matrix
     */
    public MatrixImplCSet(double[][] matrix) {
	initialize(matrix);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void initialize(double[][] matrix) {
	this.values = new HashSet<ElementVO>();
	rowLength = matrix.length;
	for (int y = 0; y < rowLength; y++) {
	    for (int x = 0; x < rowLength; x++) {
		if (matrix[y][x] != 0) {
		    this.values.add(new ElementVO(matrix[y][x], x, y));
		}
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void add(MatrixInterface matrix) {
	for (int y = 0; y < rowLength; y++) {
	    for (int x = 0; x < rowLength; x++) {
		double sum = getValue(x, y) + matrix.getValue(x, y);
		setValue(sum, x, y);
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void scalarMultiplication(double scalar) {
	for (int y = 0; y < rowLength; y++) {
	    for (int x = 0; x < rowLength; x++) {
		double value = getValue(x, y);
		if (value != 0) {
		    setValue(value * scalar, x, y);
		}
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void matrixMultiplication(MatrixInterface matrix) {
	for (int y = 0; y < rowLength; y++) {
	    for (int x = 0; x < rowLength; x++) {
		double sum = getValue(x, y) * matrix.getValue(y, x);
		setValue(sum, x, y);
	    }
	}

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void pow(int b) {
	MatrixInterface m = clone();
	for (int i = 1; i < b; i++) {
	    matrixMultiplication(m);
	}

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public double getValue(int x, int y) {
	double result = 0;
	ElementVO dummy = new ElementVO(0, x, y);
	if (values.contains(dummy)) {
	    for (ElementVO element : values) {
		if (element.x == x && element.y == y) {
		    result = element.value;
		}
	    }
	}
	return result;
    }

    /**
     * @param value
     * @param x
     * @param y
     */
    private void setValue(double value, int x, int y) {
	ElementVO dummy = new ElementVO(0, x, y);
	if (values.contains(dummy)) {
	    values.remove(dummy);
	}
	if (value != 0) {
	    values.add(new ElementVO(value, x, y));
	}
    }

    /**
     * {@inheritDoc }
     */
    public MatrixInterface clone() {

	double[][] matrix = new double[rowLength][rowLength];

	for (ElementVO element : values) {
	    matrix[element.y][element.x] = element.value;
	}

	return new MatrixImplCSet(matrix);
    }

    /**
     * @author Florian Bauer
     * 
     */
    private class ElementVO {
	private final double value;
	private final int x;
	private final int y;

	/**
	 * @param value
	 * @param x
	 * @param y
	 */
	private ElementVO(double value, int x, int y) {
	    this.value = value;
	    this.x = x;
	    this.y = y;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + getOuterType().hashCode();
	    result = prime * result + x;
	    result = prime * result + y;
	    return result;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    ElementVO other = (ElementVO) obj;
	    if (!getOuterType().equals(other.getOuterType()))
		return false;
	    if (x != other.x)
		return false;
	    if (y != other.y)
		return false;
	    return true;
	}

	private MatrixImplCSet getOuterType() {
	    return MatrixImplCSet.this;
	}
    }
}
