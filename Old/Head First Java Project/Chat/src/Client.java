import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.09.13
 * Time: 17:30
 */
public class Client {

    PrintWriter writer;
    JTextField messageField;

    public static void main(String[] args) {
        new Server().run();
    }

    public void run(){
        JFrame frame = new JFrame("Chat Client");
        JPanel mainPanel = new JPanel();
        messageField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(messageField);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if(e.getNewState() == WindowEvent.WINDOW_CLOSING && writer != null) {
                    writer.close();
                }
            }
        });
        setupNetwork();
    }

    private void setupNetwork(){
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println(messageField.getText());
            writer.flush();
            messageField.setText("");
            messageField.requestFocus();
        }
    }
}
