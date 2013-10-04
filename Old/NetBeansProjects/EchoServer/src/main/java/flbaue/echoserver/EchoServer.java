/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.echoserver;

import flbaue.utils.SocketUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author florianbauer
 */
public class EchoServer {

    private static final int PORT_NR = 7771;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Listening on port " + PORT_NR);
        final ServerSocket serverSocket = new ServerSocket(PORT_NR);

        while (!Thread.currentThread().isInterrupted()) {

            Socket socket = null;
            try {
                socket = serverSocket.accept();
                handleNewConnection(socket);
            } finally {
                SocketUtils.safeClose(socket);
            }
        }
    }

    private static void handleNewConnection(final Socket socket) throws IOException, InterruptedException {
        InputStream in = null;
        OutputStream out = null;

        try {

            System.out.println("Client connected");

            in = new BufferedInputStream(socket.getInputStream());
            out = new BufferedOutputStream(socket.getOutputStream());

            // Warte auf Daten vom Client
            while (in.available() <= 0) {
                Thread.sleep(50);
            }

            // Antwort einlesen und ausgeben
            final int available = in.available();
            final byte[] buffer = new byte[available];
            in.read(buffer);

            // daten in den Ausgabestream schreiben => an Client senden
            System.out.println("Sending answer to client '" + new String(buffer) + "'");
            out.write(buffer);
            out.flush();


        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
