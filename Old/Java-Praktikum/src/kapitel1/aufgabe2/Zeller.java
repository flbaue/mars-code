package kapitel1.aufgabe2;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 10.07.13
 * Time: 00:03
 */
public class Zeller {

    public static void main(String[] args){

        if(args.length == 0){
            args = new String[]{"10","7","2013"};
        }

        int d = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2].substring(2));
        int c = Integer.parseInt(args[2].substring(0,2));

        int w = (d + ((26*(m+1))/10) + ((5*y)/4) + (c/4) + (5*c) - 1) % 7;

        System.out.println(w);

    }
}
