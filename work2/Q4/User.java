import java.util.*;

public class User{
    private static double resp;

    public static void main(String[] args){
        try {
            Proxy userProxy = new Proxy();
            Scanner s = new Scanner(System.in);

            System.out.println("Calculator\nPlease, inform the first operand:");
            double n1 = s.nextDouble();
            System.out.println("Now, inform the operator:");
            char opt = s.next().toCharArray()[0];
            System.out.println("Lastly, inform the second operand:");
            double n2 = s.nextDouble();
            

            switch(opt){
                case '+':
                    resp = userProxy.add(n1, n2);
                    break;
                case '-':
                    resp = userProxy.sub(n1, n2);
                    break;
                case '*':
                    resp = userProxy.mul(n1, n2);
                    break;
                case '/':
                    resp = userProxy.div(n1, n2);
                    break;
                default:
                    break;
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