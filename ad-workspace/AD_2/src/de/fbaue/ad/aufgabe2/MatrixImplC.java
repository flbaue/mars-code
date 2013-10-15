/**
 * Florian Bauer
 * flbaue@posteo.de
 * 07.10.2013
 * MatrixImplC.java
 */
package de.fbaue.ad.aufgabe2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixImplC implements MatrixInterface {

    private List<ElementVO> values;
    private int rowLength;

    /**
     * @param matrix
     */
    public MatrixImplC(double[][] matrix) {
	initialize(matrix);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void initialize(double[][] matrix) {
	this.values = new ArrayList<ElementVO>();
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
	Iterator<ElementVO> iterator = values.iterator();
	while (iterator.hasNext()) {
	    ElementVO element = iterator.next();
	    int x = element.x;
	    int y = element.y;
	    double sum = element.value + matrix.getValue(x, y);
	    if (sum != 0) {
		element.value = sum;
	    } else {
		iterator.remove();
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void scalarMultiplication(double scalar) {
	if (scalar == 0) {
	    values.clear();
	}
	for (ElementVO element : values) {
	    element.value = element.value * scalar;
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void matrixMultiplication(MatrixInterface matrix) {
	Iterator<ElementVO> iterator = values.iterator();
	while (iterator.hasNext()) {
	    ElementVO element = iterator.next();
	    int y = element.x;
	    int x = element.y;
	    double otherValue = matrix.getValue(x, y);
	    if (otherValue != 0) {
		element.value = element.value * otherValue;
	    } else {
		iterator.remove();
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
	for (ElementVO element : values) {
	    if (element.x == x && element.y == y) {
		result = element.value;
	    }
	}
	return result;
    }

    /**
     * {@inheritDoc }
     */
    public MatrixInterface clone() {

	double[][] matrix = new double[rowLength][rowLength];

	for (ElementVO element : values) {
	    matrix[element.y][element.x] = element.value;
	}

	return new MatrixImplC(matrix);
    }

    /**
     * @author Florian Bauer
     * 
     */
    private class ElementVO {
	private double value;
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

	private MatrixImplC getOuterType() {
	    return MatrixImplC.this;
	}
    }
}
