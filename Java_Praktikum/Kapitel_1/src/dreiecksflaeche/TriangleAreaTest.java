/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package dreiecksflaeche;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Florian Bauer on 10.02.14. flbaue@posteo.de
 */
public class TriangleAreaTest {

    private String[] values = null;
    private double area = 0;

    @Test
    public void testArea() throws Exception {
        values = new String[]{"-1", "0", "0", "2", "1", "0"};
        area = new TriangleArea().area(values);
        assertEquals(2.0, area, 0.001);

        values = new String[]{"0", "0", "1", "1", "2", "2"};
        area = new TriangleArea().area(values);
        assertEquals(0.0, area, 0.001);

        values = new String[]{"0", "0", "0", "0", "1", "1"};
        area = new TriangleArea().area(values);
        assertEquals(0.0, area, 0.001);

        values = new String[]{"1", "1", "1", "1", "1", "1"};
        area = new TriangleArea().area(values);
        assertEquals(0.0, area, 0.001);
    }
}
