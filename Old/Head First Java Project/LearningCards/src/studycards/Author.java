package studycards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 17.08.13
 * Time: 21:52
 */
public class Author {

    private JFrame frame;
    private JTextArea frage;
    private JTextArea antwort;
    private List<QuizKarte> kartenListe;


    public static void main(String[] args){
        new Author().run();
    }

    public void run(){

        frame = new JFrame("Cards Author");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font font = new Font("sanserif", Font.TRUETYPE_FONT, 24);

        frage = new JTextArea(6,20);
        frage.setLineWrap(true);
        frage.setWrapStyleWord(true);
        frage.setFont(font);

        JScrollPane fScroller = new JScrollPane(frage);
        fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        antwort = new JTextArea(6,20);
        antwort.setLineWrap(true);
        antwort.setWrapStyleWord(true);
        antwort.setFont(font);

        JScrollPane aScroller = new JScrollPane(antwort);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextCard = new JButton("Nächste Karte");
        nextCard.addActionListener(new NextCardListener());

        kartenListe = new ArrayList<>();

        JLabel fLabel = new JLabel("Die Frage lautet:");
        JLabel aLabel = new JLabel("Die Antwort lautet:");

        mainPanel.add(fLabel);
        mainPanel.add(fScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextCard);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Datei");
        JMenuItem fileMenuNew = new JMenuItem("Neu");
        fileMenuNew.addActionListener(new MenuNewListener());
        JMenuItem fileMenuSave = new JMenuItem("Speichern");
        fileMenuSave.addActionListener(new MenuSaveListener());

        fileMenu.add(fileMenuNew);
        fileMenu.add(fileMenuSave);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
        frage.requestFocus();

    }

    private void kartenAbräumen(){
        frage.setText("");
        antwort.setText("");
        frage.requestFocus();
    }

    private void dateiSpeicher(File datei){

        if(datei == null)
            return;

        try{
            BufferedWriter  writer = new BufferedWriter(new FileWriter(datei));
            for(QuizKarte karte : kartenListe){
                writer.write(karte.getFrage() + "/");
                writer.write(karte.getAntwort() + "\n");
            }
            writer.close();

        } catch (IOException ex) {ex.printStackTrace();}
    }

    private class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
            kartenListe.add(karte);
            kartenAbräumen();
        }
    }
    private class MenuNewListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kartenListe.clear();
            kartenAbräumen();
        }
    }
    private class MenuSaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizKarte karte = new QuizKarte(frage.getText(), antwort.getText());
            kartenListe.add(karte);

            JFileChooser dateiWahl = new JFileChooser();
            dateiWahl.showSaveDialog(frame);
            dateiSpeicher(dateiWahl.getSelectedFile());
        }
    }
}
