/**
 * MatrixA.java
 * Florian Bauer
 * flbaue@posteo.de
 * 28.10.2013
 */
package matrix2;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixA extends AbstractMatrix {

    private static final MatrixImplType TYPE = MatrixImplType.A;
    private double[][] values;

    /**
     * @param typ
     */
    public MatrixA(int n) {
	super(TYPE);
	values = new double[n][n];
    }

    /**
     * @param typ
     */
    public MatrixA(double[][] values) {
	super(TYPE);
	this.values = values;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public double getValue(int x, int y) {
	return values[y][x];
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void setValue(int x, int y, double value) {
	values[y][x] = value;

    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getSize() {
	return values.length;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int getNumberOfStoredElements() {
	return values.length * values.length;
    }

}
