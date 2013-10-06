/**
 * Florian Bauer
 * flbaue@posteo.de
 * 07.10.2013
 * MatrixGenerator.java
 */
package de.fbaue.ad.aufgabe2;

import java.util.Random;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixGeneratorUtil {

    /**
     * Generates a 2D double array to initialize a matrix implementation.
     * 
     * @param n the dimension of the matrix
     * @param min the minimal value within a cell
     * @param max the maximal value within a cell
     * @param notNull the probability that the cell is not 0. (0 - 100)
     * @return the 2D double array
     */
    public static double[][] randomMatrix(int n, int min, int max, int notNull) {
	Random random = new Random();
	double[][] matrix = new double[n][n];
	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		if (random.nextInt(100) + 1 <= notNull) {
		    matrix[y][x] = min + random.nextDouble()
			    * ((max - min) + 1);
		} else {
		    matrix[y][x] = 0;
		}
	    }
	}
	return matrix;
    }
}