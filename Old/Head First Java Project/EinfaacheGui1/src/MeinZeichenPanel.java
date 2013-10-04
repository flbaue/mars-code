import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 16.06.13
 * Time: 23:17
 */
public class MeinZeichenPanel extends JPanel {

    Color[] randomColor;

    public void paintComponent(Graphics g){

//        g.setColor(Color.orange);
//
//        g.fillRect(20,50,100,100);

        System.out.println(g.getClass());

        g.fillRect(0,0,this.getWidth(),this.getHeight());

        randomColor = new Color[2];

        for(int i = 0; i < 2; i++) {
            int rot = (int) (Math.random() * 255);
            int grün = (int) (Math.random() * 255);
            int blau = (int) (Math.random() * 255);

            randomColor[i] = new Color(rot,grün,blau);
        }

        GradientPaint gradient = new GradientPaint(50,50,randomColor[0],150,150,randomColor[1]);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradient);
        //g2d.setColor(randomColor[0]);
        //g.setColor(randomColor);
        //g.fillRect(70, 70, 100, 100);
        //g2d.draw3DRect(70,70,50,50,true);
        //g2d.fill3DRect(70,70,50,50,true);

        Shape shape = new RoundRectangle2D.Double(50,50,150,150,25,25);

        g2d.fill(shape);
        Shape border = shape.getBounds2D();

        g2d.setColor(Color.BLUE);
        g2d.draw(border);
    }

    public String toString(){
        return "Color 1 ='"+ randomColor[0].toString() + "', " +
                "Color 2 = '" + randomColor[1].toString() +"'";
    }
}
