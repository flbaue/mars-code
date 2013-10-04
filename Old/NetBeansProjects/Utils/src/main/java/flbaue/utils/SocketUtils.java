package flbaue.utils;

import java.io.IOException;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class SocketUtils {

    public static void safeClose(final Socket socket) {

        try {

            if (socket != null) {
                socket.close();
            }
        } catch (final IOException e) {
            // IOException bei close ignorieren
        }
    }
}
