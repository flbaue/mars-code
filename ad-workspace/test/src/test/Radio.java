package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Radio {
    public static void main(String[] args) throws InterruptedException {
	JFrame window = new JFrame();
	JButton button = new JButton("click me");
	JPanel panel = new JPanel();

	final JLabel label = new JLabel("");
	panel.add(button);
	panel.add(label);
	window.setContentPane(panel);
	window.setSize(100, 100);
	window.setVisible(true);
	window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	button.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		label.setText("Love you!");

	    }
	});

    }
}
