/**
 * Florian Bauer
 * flbaue@posteo.de
 * 06.10.2013
 * MatrixIbterface.java
 */
package de.fbaue.ad.aufgabe2;

/**
 * @author Florian Bauer
 * 
 */
public interface MatrixInterface {

    /**
     * @param values
     * @param rowLength
     */
    void initialize(final double[][] values);

    /**
     * @param matrix
     */
    void add(final MatrixInterface matrix);

    /**
     * @param skalar
     */
    void scalarMultiplication(final double scalar);

    /**
     * @param matrix
     */
    void matrixMultiplication(final MatrixInterface matrix);

    /**
     * @param b
     */
    void pow(final int b);

    /**
     * @param x
     * @param y
     * @return
     */
    double getValue(final int x, final int y);
}
