package flbaue.playground;

import java.io.Serializable;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.07.13
 * Time: 20:19
 */
public class Person implements Serializable{

    String name;
    String vorname;

    public Person(String n, String v){
        name = n;
        vorname = v;
    }

    public String toString() {

        return "'" + name + ", " + vorname + "'";
    }

}
