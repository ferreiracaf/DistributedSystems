import java.net.*;
import java.io.*;
import java.util.*;

public class Proxy{
    TCPClient userClient = new TCPClient();
    String infoStr = new String();
    String response;
    double respUser;
    char vetDouble[]; 

    userClient.sendRequest(infoStr);

    response = userClient.getResponse();

    public String add(double n1, double n2) {
        vetDouble[0] = (char)n1;
        vetDouble[1] = '+';
        vetDouble[2] = (char)n2;

        infoStr = vetDouble.toString();
        return infoStr;
    }

    public String sub(double n1, double n2){
        vetDouble[0] = (char)n1;
        vetDouble[1] = '+';
        vetDouble[2] = (char)n2;

        infoStr = vetDouble.toString();
        return infoStr;
    }

    public String mult(double n1, double n2){
        vetDouble[0] = (char)n1;
        vetDouble[1] = '+';
        vetDouble[2] = (char)n2;

        infoStr = vetDouble.toString();
        return infoStr;
    }

    public String div(double n1, double n2){
        vetDouble[0] = (char)n1;
        vetDouble[1] = '+';
        vetDouble[2] = (char)n2;

        infoStr = vetDouble.toString();
        
        return infoStr;
    }

    public Double userResponse(){
        respUser = Double.parseDouble(response);
        return respUser;
	}

    public void close(){
		try{
			userClient.close();
		} catch (Exception e){
			System.out.println("close: " + e.getMessage());
		}
    }
}