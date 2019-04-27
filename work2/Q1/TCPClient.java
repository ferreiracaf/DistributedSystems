import java.net.*;
import java.io.*;
import java.util.*;

public class TCPClient {
	int serverPort;
	Socket s;    
	DataInputStream in;
	DataOutputStream out; //= new DataOutputStream( s.getOutputStream());

  public TCPClient(){
	  try {
		serverPort = 7896;
		s = new Socket("localhost", serverPort);
		in = new DataInputStream( s.getInputStream());
		out = new DataOutputStream( s.getOutputStream());
	  } catch (IOException e) {System.out.println("TCPClient: " + e.getMessage());}
	}
	 
	public void sendRequest(String request){
		try {
			out.writeUTF(request);	
		} catch (Exception e) {System.out.println("ClientSendRequest: " + e.getMessage());
		}
	}

	public String getResponse(){
		String info = null;
		try {
			info = in.readUTF();
			
		} catch (Exception e) {System.out.println("ClientSendResponse: " + e.getMessage());
		}
		return info;
	}

	public void close(){
		try{
			s.close();
		} catch (IOException e){System.out.println("close: " + e.getMessage());}
	}
}
