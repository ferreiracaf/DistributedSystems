import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Handler {
	public static List<Socket> clients = new ArrayList<Socket>();
	
	public boolean searchSocket(Socket socket){
		for (Socket s : clients) {
			if(s.equals(socket))
				return true;
		}
		return false;
    }
    
    public void addClient(Socket socket){
        clients.add(socket);
    }
    public int getSocketIndex(Socket socket){
        return clients.indexOf(socket);
    }
}
