import java.net.*;
import java.io.*;
import java.util.*;
// import jdk.nashorn.internal.ir.RuntimeNode.Request;	

public class TCPServer {

	public static void main (String args[]) {
		try{
			int serverPort = 7896;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			Handler handler = new Handler();
			while(true) {
				Socket clientSocket = listenSocket.accept();
				
				if(!handler.searchSocket(clientSocket)) {
					handler.addClient(clientSocket);
				}
				int ind = handler.getSocketIndex(clientSocket);
				Connection c = new Connection(clientSocket, handler, ind);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	Handler handler;
    FowardingAgent fAgent;
    
	public Connection (Socket aClientSocket, Handler h1, int ind) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			handler = h1;
			fAgent = new FowardingAgent();
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
    }
    
    public String getRequest(){
		String request = null;
		try {
			request = in.readUTF();	
		} catch (Exception e) {System.out.println("ServergetRequest: " + e.getMessage());
		}
        return request;
    }

    public void sendResponse(String response){
		try {
			out.writeUTF(response);
		} catch (Exception e) {System.out.println("ServerSendRequest: " + e.getMessage());
		}
    }

	public void run(){
		try {
            String data = this.getRequest();

			String strResp = fAgent.invoke(data);
			
			this.sendResponse(strResp);

		// }
		// catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		// } catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (Exception e){/*close failed*/}}
		
    }
}