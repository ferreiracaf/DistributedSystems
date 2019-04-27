import java.net.*;
import java.io.*;
import java.util.*;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class TCPServer {

	public static void main (String args[]) {
		try{
			int serverPort = 7896;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			Handler handler = new Handler();
			while(true) {
				Socket clientSocket = listenSocket.accept();
				
				if(!handler.search(clientSocket)) {
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
        String request = in.readUTF();
        return request;
    }

    public void sendResponse(String response){
        out.writeUTF(response);
    }

	public void run(){
		try {
            Calculator c = new Calculator();

			String data = this.getRequest();

			String array[] = new String[3];
			array = data.split(" ");
			
			String strResp = "Deu ruim";
			double resp = 0;

            double n1 = Double.valueOf(array[0]);
            double n2 = Double.valueOf(array[2]);
            char opt = array[1].toCharArray()[0];
            
            resp = c.calc(n1, n2, opt);
            
            strResp = Double.toString(resp);
			
			this.sendResponse(strResp);

		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		
    }
}