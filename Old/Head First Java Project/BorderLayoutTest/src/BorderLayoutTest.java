import javax.swing.*;
import java.awt.*;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 14.08.13
 * Time: 14:36
 */
public class BorderLayoutTest{

    public static void main(String[] arsg){
        BorderLayoutTest borderLayoutTest = new BorderLayoutTest();
        borderLayoutTest.run();
    }

    public void run(){

        JFrame frame = new JFrame("BorderLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton north = new JButton("North");
        JButton east = new JButton("East");
        JButton south = new JButton("South");
        JButton west = new JButton("West");
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.NORTH,north);
        frame.getContentPane().add(BorderLayout.EAST,east);
        frame.getContentPane().add(BorderLayout.SOUTH,south);
        frame.getContentPane().add(BorderLayout.WEST,west);
        frame.getContentPane().add(BorderLayout.CENTER,center);

        frame.setSize(200,200);
        frame.setVisible(true);

    }
}
