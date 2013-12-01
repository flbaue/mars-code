/*
 * Florian Bauer
 * flbaue@posteo.de
 * 2013
 */

package hausaufgabe52;

import org.junit.Assert;
import org.junit.Test;
import static hausaufgabe52.Implementation.*;

/**
 * User: flbaue
 * Date: 30.11.13
 * Time: 18:45
 */
public class ImplementationTest {
    @Test
    public void testF() throws Exception {

        Assert.assertEquals(1,f(0));
        Assert.assertEquals(1,f(1));
        Assert.assertEquals(1,f(2));
        Assert.assertEquals(6,f(3));
        Assert.assertEquals(11,f(4));
        Assert.assertEquals(26,f(5));
        Assert.assertEquals(66,f(6));
        Assert.assertEquals(151,f(7));
        Assert.assertEquals(361,f(8));
        Assert.assertEquals(861,f(9));

        for (int i = 0; i < 100000; i++) {

            System.out.print("f(" + i + ") = ");
            System.out.print(f(i) + "\n");
        }

    }
}
