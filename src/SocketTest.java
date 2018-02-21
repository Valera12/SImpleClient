import java.io.*;
import java.net.*;


public class SocketTest {

    public static void main(String[] args) {
        try{
        Socket socket = new Socket("localhost", 8189);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean more = true;
        while (more){
            String line = in.readLine();
            if(line == null)
                more = false;
            else System.out.println(line);
        }
        }
        catch (IOException e){
          e.printStackTrace();
        }
    }
}
