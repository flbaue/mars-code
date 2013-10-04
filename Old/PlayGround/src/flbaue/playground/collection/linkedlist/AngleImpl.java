package flbaue.playground.collection.linkedlist;

import flbaue.playground.Angle;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 06.07.13
 * Time: 16:48
 */
public class AngleImpl implements Angle {

    private double value;

    private AngleImpl(double value) {this.value = value;};

    public static Angle valueOf(String s) {
        return new AngleImpl(Double.valueOf(s));
    }

    public double getValue() {return value;};

    @Override
    public int compareTo(Angle o) {

        if(getValue() == o.getValue())
            return 0;

        if(getValue() < o.getValue())
            return -1;
        else
            return 1;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if(o == null)
            return false;

        if(!(o instanceof Angle))
            return false;

        Angle other = (Angle)o;
        return compareTo(other) == 0;
    }

    @Override
    public int hashCode() {

        return (int)Math.round(31*value);
    }
}
