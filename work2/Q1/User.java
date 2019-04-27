import java.net.*;
import java.io.*;
import java.util.*;

public class User{

    public static void main(String[] args){
        
        TCPClient userClient = null;
        try {
            userClient = new TCPClient();
            String resp = new String();
            String info = new String();
            Scanner s = new Scanner(System.in);

            System.out.println("Informe o que deseja calcular no seguinte formato:\n\t\"n1 op n2\"");
            info = s.nextLine();

            userClient.sendRequest(info);

            resp = userClient.getResponse();

            System.out.println(resp);
            
            s.close();
            
        } catch (Exception e) {
            System.out.println("User main: " + e.getMessage());
        }finally {try {userClient.close();}catch (Exception e){/*close failed*/}}
    }
}