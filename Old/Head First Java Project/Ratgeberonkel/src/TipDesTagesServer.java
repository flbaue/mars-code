import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.09.13
 * Time: 16:35
 */
public class TipDesTagesServer {

    public void los(){

        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            boolean stopp = false;
            int count = 0;

            while(!stopp) {

                Socket clientSocket = serverSocket.accept();
                count++;


                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                String tipp = "test tipp";
                writer.println(tipp);
                writer.close();
                System.out.println("count:" + count);

                stopp = (count >= 2) ? true : false;

            }



        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static  void main(String[] args){
        new TipDesTagesServer().los();
    }
}
