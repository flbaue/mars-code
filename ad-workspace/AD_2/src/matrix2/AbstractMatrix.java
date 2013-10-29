/**
 * AbstractMatrix.java
 * Florian Bauer
 * flbaue@posteo.de
 * 28.10.2013
 */
package matrix2;

/**
 * @author Florian Bauer
 * 
 */
public abstract class AbstractMatrix implements Matrix {

    private static int TYPE;

    public AbstractMatrix(int type) {
	TYPE = type;
    }

    public Matrix add(final Matrix m) {

	Matrix resultMatrix = AbstractMatrix.makeMatrix(TYPE, getSize());

	for (int y = 0; y < getSize(); y++) {
	    for (int x = 0; x < getSize(); x++) {
		double value = getValue(x, y) + m.getValue(x, y);
		resultMatrix.setValue(x, y, value);
	    }
	}
	return resultMatrix;
    }

    public Matrix scalarMulti(final double s) {

	Matrix resultMatrix = AbstractMatrix.makeMatrix(TYPE, getSize());

	for (int y = 0; y < getSize(); y++) {
	    for (int x = 0; x < getSize(); x++) {
		double value = getValue(x, y) * s;
		resultMatrix.setValue(x, y, value);
	    }
	}
	return resultMatrix;
    }

    public Matrix matrixMulti(final Matrix m) {

	Matrix resultMatrix = AbstractMatrix.makeMatrix(TYPE, getSize());

	for (int y = 0; y < getSize(); y++) {
	    for (int x = 0; x < getSize(); x++) {
		double value = getValue(x, y) * m.getValue(y, x);
		resultMatrix.setValue(x, y, value);
	    }
	}
	return resultMatrix;
    }

    public Matrix pow(int x) {
	Matrix resultMatrix = this;

	for (int i = 1; i < x; i++) {
	    resultMatrix = matrixMulti(resultMatrix);
	}

	return resultMatrix;
    }

    public static Matrix makeMatrix(int type, int dimension) {
	if (type == 0)
	    return new MatrixA(dimension);
	if (type == 1)
	    return new MatrixB(dimension);
	if (type == 2)
	    return new MatrixC(dimension);

	throw new IllegalArgumentException("Unkonwn Typ");
    }
}
