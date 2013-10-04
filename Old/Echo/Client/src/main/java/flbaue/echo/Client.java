package flbaue.echo;

import flbaue.echo.utils.SocketUtil;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 31.05.13
 * Time: 11:26
 */
public class Client {

    private static final int PORT_NR = 7771;

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {

            // Aufbau der Verbindnung
            System.out.println("Connecting to server");
            final String serverIP = "127.0.0.1";
            socket = new Socket(serverIP, PORT_NR);

            //Zugriff auf die Streams
            in = new BufferedInputStream(socket.getInputStream());
            out = new BufferedOutputStream(socket.getOutputStream());


            // Konsole lesen
            Scanner inCon = new Scanner(System.in);
            String message = inCon.nextLine();

            // Daten in Stream schreiben => an den Server senden
            System.out.println("Sending '" + message + "' to server");
            out.write(message.getBytes());
            out.flush();

            // warten auf Antwort vom Server
            while (in.available() <= 0) {
                Thread.sleep(50);
            }

            // Antwort auslesen und ausgeben
            System.out.println("Receiving answer from server");
            final int available = in.available();
            final byte[] buffer = new byte[available];
            in.read(buffer);
            System.out.println("Answer ='" + new String(buffer) + "'");


        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            SocketUtil.safeClose(socket);
        }
    }
}
