import java.net.*;
import java.io.*;
import java.util.*;

public class Proxy{
    TCPClient userClient;
    private double resp;

    public Proxy(){
        try {
            userClient = new TCPClient();    
        } catch (Exception e) {
            System.out.println("Proxy: "+e.getMessage());
        }
    }

    public void initChat(){

    }

    public void showClients(){
        
    }

    public double add(double n1, double n2) {
        try {
            userClient.sendRequest(String.valueOf(n1)+" + "+String.valueOf(n2));
            resp = Double.valueOf(userClient.getResponse());
        } catch (Exception e) {
            System.out.println("Proxy add(): "+e.getMessage());
        }
        return resp;
    }

    public double sub(double n1, double n2){
        try {
            userClient.sendRequest(String.valueOf(n1)+" - "+String.valueOf(n2));
            resp = Double.valueOf(userClient.getResponse());
        } catch (Exception e) {
            System.out.println("Proxy sub(): "+e.getMessage());
        }
        return resp;
    }

    public double mul(double n1, double n2){
        try {
            userClient.sendRequest(String.valueOf(n1)+" * "+String.valueOf(n2));
            resp = Double.valueOf(userClient.getResponse());
        } catch (Exception e) {
            System.out.println("Proxy mul(): "+e.getMessage());
        }
        return resp;
    }

    public double div(double n1, double n2){
        try {
            userClient.sendRequest(String.valueOf(n1)+" / "+String.valueOf(n2));
            resp = Double.valueOf(userClient.getResponse());
        } catch (Exception e) {
            System.out.println("Proxy div(): "+e.getMessage());
        }
        return resp;
    }

    public void close(){
		try{
			userClient.close();
		} catch (Exception e){
			System.out.println("Proxy close client: " + e.getMessage());
		}
    }
}