import java.net.*;
import java.io.*;
import java.util.*;

public class TCPClient {
	Socket s;    
	int serverPort;
	DataInputStream in;
	DataOutputStream out;

  public TCPClient(){
		serverPort = 7896;
		s = new Socket("localhost", serverPort);
		in = new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
	}
	 
	public void sendRequest(String request){
		out.writeUTF(request);
	}

	public String getResponse(){
		String info = in.readUTF();
		return info;
	}

	public void close(){
		try{
			s.close();
		} catch (Exception e){
			System.out.println("close: " + e.getMessage());
		}
	}
}
