package flbaue.echo;

import flbaue.echo.utils.SocketUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 31.05.13
 * Time: 11:26
 */
public class Server {
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
                SocketUtil.safeClose(socket);
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



