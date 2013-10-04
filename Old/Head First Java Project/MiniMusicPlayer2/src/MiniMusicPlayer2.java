/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 14.08.13
 * Time: 13:48
 */
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer2 implements ControllerEventListener {

    private JFrame f = new JFrame("Mein erstes Musikvideo");
    private MeinZeichenPanel m1;

    public static void main(String[] args){
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.los();
    }

    private void guiErstellen() {
        m1 = new MeinZeichenPanel();
        f.setContentPane(m1);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void los(){

         guiErstellen();

        try{

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            int[] wantedEvents = {127};
            sequencer.addControllerEventListener(m1, wantedEvents);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for(int i = 5; i < 60; i += 4){
                track.add(createEvent(176,1,127,0,i));
                track.add(createEvent(128,1,i,100,i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
            Thread.sleep(5000);
            sequencer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("la");
    }

    public static MidiEvent createEvent(int comd, int chan, int one, int two, int tick){

        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return event;
    }

    private class MeinZeichenPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {

            if(msg){
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g2.setColor(new Color(r,gr,b));

                int höhe = (int) ((Math.random()*120) + 10);
                int breite = (int) ((Math.random()*120) + 10);
                int x = (int) ((Math.random()*40) + 10);
                int y = (int) ((Math.random()*40) + 10);

                g2.fillRect(x,y,breite,höhe);

                msg = false;
            }
        }
    }
}
