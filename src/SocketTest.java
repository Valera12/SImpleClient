import java.io.*;
import java.net.*;


public class SocketTest {

    public static void main(String[] args) {
        try{

        Socket socket = new Socket("localhost", 8189);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
        String msgFromUser;
            System.out.println("Enter messages to send:");
            while((msgFromUser = inFromUser.readLine()) != null){
                outToServer.println(msgFromUser);
                String msgFromServer = inFromServer.readLine();
                System.out.println(msgFromServer);
            }

                inFromServer.close();
                inFromUser.close();
                outToServer.close();
                socket.close();
            
        }
        catch (IOException e){
          e.printStackTrace();
        }
    }
}
