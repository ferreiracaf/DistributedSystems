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
	
	public TCPClient(int port){
		try {
			serverPort = port;
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

	/**
	 * @return the serverPort
	 */
	public int getServerPort() {
		return serverPort;
	}

	/**
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 * @return the s
	 */
	public Socket getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(Socket s) {
		this.s = s;
	}

	/**
	 * @return the in
	 */
	public DataInputStream getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(DataInputStream in) {
		this.in = in;
	}

	/**
	 * @return the out
	 */
	public DataOutputStream getOut() {
		return out;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(DataOutputStream out) {
		this.out = out;
	}
}
