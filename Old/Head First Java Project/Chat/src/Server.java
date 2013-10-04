import java.io.IOException;
import java.net.ServerSocket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.09.13
 * Time: 17:30
 */
public class Server {

    public static void main(String[] args){
        new Server().run();
    }

    public void run(){

        try {
            ServerSocket serverSocket = new ServerSocket("5000");

            boolean stopp = false;

            while(!stopp){




            }




        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



}
