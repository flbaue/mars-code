import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.09.13
 * Time: 16:17
 */
public class TipDesTagesClient {

    public void los() {

        try {
            Socket socket = new Socket("127.0.0.1",4242);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String tipp = bufferedReader.readLine();
            System.out.println("Tipp: " + tipp);

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){

        new TipDesTagesClient().los();

    }

}
