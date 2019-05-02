import java.util.*;

public class User{

    public static void main(){
        Proxy userProxy = new Proxy();
        double[] info = new double[3];
        double resp;
        Scanner s = new Scanner(System.in);

        System.out.println("\tCalculadora - Opções:\n1 - Adição\n2 - Subtração\n3 - Multiplicação\n" +
        "4 - Divisão\n\nInforme o que deseja calcular no seguinte formato:\n\t\"op n1 n2\"");

        for (int i = 0; i < 3; i++) {
            info[i] = s.nextDouble();
        }

        switch((int)info[0]){
            case 1:
                userProxy.add(info[1], info[2]);
                break;
            case 2:
                userProxy.sub(info[1], info[2]);
                break;
            case 3:
                userProxy.mult(info[1], info[2]);
                break;
            case 4:
                userProxy.div(info[1], info[2]);
                break;
        }

        resp = userProxy.userResponse();

        System.out.println(resp);
        
        s.close();
        userProxy.close();
    }
}