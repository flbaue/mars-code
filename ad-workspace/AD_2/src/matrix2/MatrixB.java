/**
 * MatrixA.java
 * Florian Bauer
 * flbaue@posteo.de
 * 28.10.2013
 */
package matrix2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florian Bauer
 * 
 */
public class MatrixB extends AbstractMatrix {

    private static final int TYP = 1;
    private List<Double>[] values;
    private int rowLength;

    /**
     * @param typ
     */
    @SuppressWarnings("unchecked")
    public MatrixB(int n) {
	super(TYP);
	rowLength = n;
	values = new List[rowLength];
	for (int y = 0; y < rowLength; y++) {
	    values[y] = new ArrayList<Double>(rowLength);
	}
    }

    /**
     * @param typ
     */
    @SuppressWarnings("unchecked")
    public MatrixB(double[][] values) {
	super(TYP);
	rowLength = values.length;
	this.values = new List[rowLength];
	for (int y = 0; y < rowLength; y++) {
	    this.values[y] = new ArrayList<Double>(rowLength);
	    for (int x = 0; x < rowLength; x++) {
		setValue(x, y, values[y][x]);
	    }
	}
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public double getValue(int x, int y) {
	int position = x;
	Double value = values[y].get(position);
	if (value != null)
	    return value;
	else
	    return 0;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void setValue(int x, int y, double value) {
	int position = x;
	if (values[y].size() == position) {
	    if (value == 0) {
		values[y].add(null);
	    } else {
		values[y].add(value);
	    }
	} else {
	    if (value == 0) {
		values[y].set(position, null);
	    } else {
		values[y].set(position, value);
	    }
	}
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
	int sum = 0;
	for (int y = 0; y < values.length; y++) {
	    for (int pos = 0; pos < values[y].size(); pos++) {
		if (values[y].get(pos) != null)
		    sum++;
	    }
	}
	return sum;
    }
}
