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
	int index;
	Handler handler;
	
	public Connection (Socket aClientSocket, Handler h1, int ind) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			handler = h1;
			index = ind;
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

			String array[] = new String[2];
			array = data.split("@");
            
            Message msg = new Message(Integer.parseInt(array[1]), array[0], clientSocket.getPort());
			// String strResp = "Deu ruim";
			// double resp = 0;

            // double n1 = Double.valueOf(array[0]);
            // double n2 = Double.valueOf(array[2]);
            // char opt = array[1].toCharArray()[0];
            
            // resp = c.calc(n1, n2, opt);
            
            // strResp = Double.toString(resp);
			
			// this.sendResponse(strResp);










		// }
		// catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		// } catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (Exception e){/*close failed*/}}
		
    }
}