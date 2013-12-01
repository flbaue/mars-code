/*
 * Florian Bauer
 * flbaue@posteo.de
 * 2013
 */

package hausaufgabe52;

/**
 * User: flbaue
 * Date: 30.11.13
 * Time: 18:42
 */
public class Implementation {


    public static int f(int n) {

        Implementation impl = new Implementation();
        System.out.println("f(" + n + ")");

    }

    private int function(int n) {
        if (n < 3) {
            return 1;
        } else {
            return f(n - 1) + 2 * f(n - 2) + 3 * f(n - 3);
        }
    }

}
