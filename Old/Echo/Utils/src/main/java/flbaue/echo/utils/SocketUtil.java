package flbaue.echo.utils;

import java.io.IOException;
import java.net.Socket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 31.05.13
 * Time: 11:50
 */
public class SocketUtil {

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

