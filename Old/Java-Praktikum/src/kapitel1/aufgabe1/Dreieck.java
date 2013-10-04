package kapitel1.aufgabe1;



/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 09.07.13
 * Time: 20:51
 */
public class Dreieck {

    public static void main (String[] args) {

        if(args[0].equals("test")){
            args = new String[]{"0","0","1","1","2","2"};
        }

        // A(x,y) B(x,y) C(x,y)
        Point a = new Point(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        Point b = new Point(Double.parseDouble(args[2]),Double.parseDouble(args[3]));
        Point c = new Point(Double.parseDouble(args[4]),Double.parseDouble(args[5]));

        double tmp = (b.x() - a.x())*(c.y()-a.y()) - (c.x()-a.x())*(b.y()-a.y());

        double area = 0.5 * Math.abs(tmp);

        System.out.println(String.format("Fläche: %.2f", area));

    }
}
