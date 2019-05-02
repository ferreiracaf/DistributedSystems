import java.net.*;
import java.io.*;
import java.util.*;

public class TCPClient {
	Socket s;    
	int serverPort;
	DataInputStream in;
	DataOutputStream out;

  public TCPClient(){
	  try {
		serverPort = 7896;
		s = new Socket("localhost", serverPort);
		in = new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
	  } catch (Exception e) {
		  System.out.println("TCPClient :"+e.getMessage());
	  }
	}
	 
	public void sendRequest(String request){
		try {
			out.writeUTF(request);
		} catch (Exception e) {
			System.out.println("SendRequest: "+e.getMessage());
		}
	}

	public String getResponse(){
		String info = null;
		try {
			info = in.readUTF();
		} catch (Exception e) {
			System.out.println("GetResponse: "+e.getMessage());
		}
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
