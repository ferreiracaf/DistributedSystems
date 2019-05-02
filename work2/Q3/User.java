import java.net.*;
import java.io.*;
import java.util.*;

public class User{

    public static void main(String[] args){
        
        TCPClient userClient = null;
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Please inform the client port:");
            int port = s.nextInt(); 
            userClient = new TCPClient(port);

            System.out.println("Now inform the port required to stablish the chat connection:");
            int outPort = s.nextInt();

            System.out.println("Please, chat!");
            Getter getter = new Getter(userClient);
            while(true) {
                String strMsg = s.nextLine();
                if (strMsg.equals("/quit")) {
                    break;
                }
                userClient.sendRequest(strMsg+"@"+String.valueOf(outPort));
            }
            
            s.close();
            
        } catch (Exception e) {
            System.out.println("User main: " + e.getMessage());
        }finally {try {userClient.close();}catch (Exception e){/*close failed*/}}
    }
}
