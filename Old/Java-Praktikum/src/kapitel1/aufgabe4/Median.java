package kapitel1.aufgabe4;

import java.util.Arrays;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 10.07.13
 * Time: 00:18
 */
public class Median {

    public static void main(String[] args) {

        args = new String[]{"2","1","3"};

        Arrays.sort(args);
        System.out.println(args[1]);

    }
}
