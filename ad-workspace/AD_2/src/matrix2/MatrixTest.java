/**
 * MatrixInterfaceTest.java
 * Florian Bauer
 * flbaue@posteo.de
 * 27.10.2013
 */
package matrix2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fbaue.ad.messreihe.Impl2Messreihe;
import fbaue.ad.messreihe.Messreihe;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixTest {

    @Test
    public void aufgabe6Test() {
	int n = 3;
	double[][] valuesA = MatrixGeneratorUtil.randomMatrix(n, 0, 10, 90);
	double[][] valuesB = MatrixGeneratorUtil.randomMatrix(n, 0, 10, 90);

	Matrix a1 = new MatrixA(valuesA);
	Matrix b1 = new MatrixA(valuesB);

	Matrix a2 = new MatrixB(valuesA);
	Matrix b2 = new MatrixB(valuesB);

	Matrix a3 = new MatrixC(valuesA);
	Matrix b3 = new MatrixC(valuesB);

	a1 = a1.matrixMulti(b1);
	a2 = a2.matrixMulti(b2);
	a3 = a3.matrixMulti(b3);

	for (int y = 0; y < n; y++) {
	    for (int x = 0; x < n; x++) {
		assertTrue(a1.getValue(x, y) == a2.getValue(x, y)
			&& a2.getValue(x, y) == a3.getValue(x, y));
	    }
	}

    }

    @Test
    public void aufgabe7Test() {
	int n = 1000;
	int t = 5;
	int p = 1;

	Messreihe valuesB = new Impl2Messreihe();
	Messreihe valuesC = new Impl2Messreihe();
	Messreihe diff = new Impl2Messreihe();
	Messreihe avgDiff = new Impl2Messreihe();

	MatrixB[] matrizenB = new MatrixB[t];
	MatrixC[] matrizenC = new MatrixC[t];

	for (int i = 0; i < t; i++) {
	    double[][] values = MatrixGeneratorUtil.randomMatrix(n, 0, 10, p);
	    matrizenB[i] = new MatrixB(values);
	    matrizenC[i] = new MatrixC(values);
	    System.out.println("B=" + matrizenB[i].getNumberOfStoredElements()
		    + " C=" + matrizenC[i].getNumberOfStoredElements());

	}
    }
}
