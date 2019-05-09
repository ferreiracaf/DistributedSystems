import java.util.*;

public class User{
    private static double resp;

    public static void main(String[] args){
        try {
            Proxy userProxy = new Proxy();
            Scanner s = new Scanner(System.in);

            System.out.println("Please inform the client port: ");
            double port = S.nextDouble();
            
            System.out.println("Client command: \n1 - Para conectar\n2 - Visualizar número de clientes conectados");
            Double command = S.nextLine();
            
            if(commad == 1){
                userProxy.initChat();
            }else if(command == 2){
                userProxy.showClients();
            }else{
                System.out.println("Comando inválido!");
            }

            // double resp = userProxy.userResponse();

            System.out.println(resp);
            
            s.close();
            userProxy.close();    
        } catch (Exception e) {
            System.out.println("User: "+e.getMessage());
        }
    }
}