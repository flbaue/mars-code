/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 16.06.13
 * Time: 19:32
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class EinfacheGui1 {

    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    MeinZeichenPanel mzp;
    SwingWorker<String,String> worker;

    int x = 50;
    int y = 50;

    public static void main(String[] args) {

        EinfacheGui1 gui = new EinfacheGui1();
        gui.los();
    }

    public void los() {

        frame = new JFrame();
        mzp = new MeinZeichenPanel();
        button1 = new JButton("Color Baby!");
        button1.addActionListener(new ColorListener());
        button2 = new JButton("Sag mir mehr!");
        button2.addActionListener(new LabelListener());
        button3 = new JButton("Nochmal!");
        button3.addActionListener(new NochmalListener());
        label = new JLabel();
        label.setText("mach ma was");
        label.getText();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, mzp);
        frame.getContentPane().add(BorderLayout.SOUTH, button1);
        frame.getContentPane().add(BorderLayout.WEST, button2);
        frame.getContentPane().add(BorderLayout.NORTH, label);
        frame.getContentPane().add(BorderLayout.EAST, button3);

        frame.setSize(700, 500);

        frame.setVisible(true);

        moveShape();

    }

    private void moveShape() {

        if(worker != null) { worker.cancel(true);};

        worker = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception {


                for(int i =0; i < 100; i++) {

                    if(isCancelled()){
                        break;
                    }

                    x++;
                    y++;

                    frame.repaint();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }

                }

                x = 50;
                y = 50;
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        worker.execute();

    }

    class LabelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            if(worker != null) {
                worker.cancel(true);
            }
            label.setText(mzp.toString());
        }
    }

    class  ColorListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

    class NochmalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            x = 50;
            y = 50;
            mzp.repaint();
            moveShape();
        }
    }

    class MeinZeichenPanel extends JPanel {

        Color[] randomColor;

        public void paintComponent(Graphics g){

//        g.setColor(Color.orange);
//
//        g.fillRect(20,50,100,100);

//            System.out.println(g.getClass());

            g.fillRect(0,0,this.getWidth(),this.getHeight());

            randomColor = new Color[2];

            for(int i = 0; i < 2; i++) {
                int rot = (int) (Math.random() * 255);
                int grün = (int) (Math.random() * 255);
                int blau = (int) (Math.random() * 255);

                randomColor[i] = new Color(rot,grün,blau);
            }

            GradientPaint gradient = new GradientPaint(x,y,randomColor[0],x+100,y+100,randomColor[1]);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(gradient);
            //g2d.setColor(randomColor[0]);
            //g.setColor(randomColor);
            //g.fillRect(70, 70, 100, 100);
            //g2d.draw3DRect(70,70,50,50,true);
            //g2d.fill3DRect(70,70,50,50,true);

            Shape shape = new RoundRectangle2D.Double(x,y,150,150,25,25);

            g2d.fill(shape);
//            Shape border = shape.getBounds2D();
//
//            g2d.setColor(Color.BLUE);
//            g2d.draw(border);
        }

        public String toString(){
            return "Color 1 ='"+ randomColor[0].toString() + "', " +
                    "Color 2 = '" + randomColor[1].toString() +"'";
        }
    }
}
