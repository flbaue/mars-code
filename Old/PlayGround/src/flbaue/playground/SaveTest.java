package flbaue.playground;

import java.io.*;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 17.08.13
 * Time: 19:12
 */
public class SaveTest {

    public static void main(String[] args){

        Person p1 = new Person("Florian","Bauer");
        Person p2 = null;

        try {
            FileOutputStream fos = new FileOutputStream("./Person");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(p1);

            oos.close();

            FileInputStream fis = new FileInputStream("./Person");
            ObjectInputStream ois = new ObjectInputStream(fis);

            p2 = (Person) ois.readObject();

            ois.close();

        } catch (Exception e) {e.printStackTrace();}

        System.out.println(p2);

    }
}
