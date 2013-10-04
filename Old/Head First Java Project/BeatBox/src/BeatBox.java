import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 14.08.13
 * Time: 15:14
 */
public class BeatBox {

    JPanel hauptPanel;
    ArrayList<JCheckBox> checkboxListe;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame frame;
    String[] instrumentNamen = {"Bassdrum", "Hi-Hat, geschlossen",
            "Hi-Hat, offen", "Snardrum", "Crashbecken", "Händeklatschen",
            "Hohes Tom-Tom", "Hohes Bongo", "Maracas", "Trillerpfeife",
            "Tiefe Conga", "Kuhglocke", "Vibraslap", "Tieferes Tom-Tom",
            "Hohes Agogo", "Hohe Conga, offen"};
    int[] instrumente = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().guiStart();
    }

    public static MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick) {

        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }

    public void guiStart() {

        frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel hintergrund = new JPanel(layout);
        hintergrund.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxListe = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MeinStartListener());
        buttonBox.add(start);

        JButton stopp = new JButton("Stopp");
        start.addActionListener(new MeinStoppListener());
        buttonBox.add(stopp);

        JButton schneller = new JButton("Schneller");
        start.addActionListener(new MeinSchnellerListener());
        buttonBox.add(schneller);

        JButton langsamer = new JButton("Langsamer");
        start.addActionListener(new MeinLangsamerListener());
        buttonBox.add(langsamer);

        Box namensBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            namensBox.add((new Label(instrumentNamen[i])));
        }

        hintergrund.add(BorderLayout.EAST, namensBox);
        hintergrund.add(BorderLayout.WEST, buttonBox);

        frame.getContentPane().add(hintergrund);

        GridLayout raster = new GridLayout(16, 16);
        raster.setVgap(1);
        raster.setHgap(2);
        hauptPanel = new JPanel(raster);
        hintergrund.add(BorderLayout.CENTER, hauptPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxListe.add(c);
            hauptPanel.add(c);
        }

        midiEinrichten();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    public void midiEinrichten() {
        try {

            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void trackErstellenUndStarten() {
        int[] trackliste = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackliste = new int[16];

            int taste = instrumente[i];

            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxListe.get(j + (16 * i));
                if (jc.isSelected()) {
                    trackliste[j] = taste;
                    System.out.println(taste);
                } else {
                    trackliste[j] = 0;
                }
            }

            tracksErzeugen(trackliste);
        }

        track.add(eventErzeugen(192, 9, 1, 0, 16));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tracksErzeugen(int[] liste) {
        for (int i = 0; i < 16; i++) {
            int taste = liste[i];
            if (taste != 0) {
                track.add(eventErzeugen(144, 9, taste, 100, i));
                track.add(eventErzeugen(128, 9, taste, 100, i + 1));
            }
        }
    }

    public class MeinStartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            trackErstellenUndStarten();
        }
    }

    public class MeinStoppListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MeinSchnellerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class MeinLangsamerListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
        }
    }
}
