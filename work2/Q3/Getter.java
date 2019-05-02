import java.io.*;
import java.net.*;
import java.util.*;

public class Getter extends Thread {
	public Socket client;
	public DataInputStream in;

    public Getter(TCPClient _client){
		try{
			this.client = _client.getS();
			this.in = new DataInputStream(client.getInputStream());
			this.start();
		} catch(Exception e) {System.out.println("Getter: "+e.getMessage());}
    }
    
	public Getter(Socket _client){
		try{
			this.client = _client;
			this.in = new DataInputStream(_client.getInputStream());
			this.start();
		} catch(Exception e) {System.out.println("Getter: "+e.getMessage());}
	}

	public void run(){
		try{
			while (true){
				String str = in.readUTF();
				System.out.println("          > "+str);
			}
		} catch(Exception e) {System.out.println("Getter run: "+e.getMessage());}
	}
}