/**
 * Florian Bauer
 * flbaue@posteo.de
 * 07.10.2013
 * MatrixGeneratorUtilTest.java
 */
package matrix2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Florian Bauer
 *
 */
public class MatrixGeneratorUtilTest {

    /**
     * 
     */
    @Test
    public void randomMatrixTest() {
	double[][] matrix = MatrixGeneratorUtil.randomMatrix(15,0,100,90);
	assertTrue(matrix.length == 15);
	assertTrue(matrix[0].length == 15);
    }

}
