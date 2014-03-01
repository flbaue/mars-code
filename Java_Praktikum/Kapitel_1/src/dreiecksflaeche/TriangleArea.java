/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package dreiecksflaeche;

/**
 * Created by Florian Bauer on 10.02.14. flbaue@posteo.de
 */
public class TriangleArea {

    public static void main(String[] args) {

        double area = new TriangleArea().area(args);

        System.out.printf("%.2f", area);
    }

    public double area(String[] args) {

        double ax = Double.parseDouble(args[0]);
        double ay = Double.parseDouble(args[1]);
        double bx = Double.parseDouble(args[2]);
        double by = Double.parseDouble(args[3]);
        double cx = Double.parseDouble(args[4]);
        double cy = Double.parseDouble(args[5]);

        double a = Math.hypot(cx - bx, cy - by);
        double b = Math.hypot(ax - cx, ay - cy);
        double c = Math.hypot(bx - ax, by - ay);

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}
