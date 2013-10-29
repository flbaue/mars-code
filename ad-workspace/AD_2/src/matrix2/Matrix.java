/**
 * Matrix.java
 * Florian Bauer
 * flbaue@posteo.de
 * 28.10.2013
 */
package matrix2;

/**
 * @author Florian Bauer
 * 
 */
public interface Matrix {

    Matrix add(final Matrix m);

    Matrix scalarMulti(final double s);

    Matrix matrixMulti(final Matrix m);

    Matrix pow(final int x);

    double getValue(final int x, final int y);

    void setValue(final int x, final int y, final double value);

    int getSize();

    int getNumberOfStoredElements();
}
