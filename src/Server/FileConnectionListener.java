package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;


/**
 * Class which will constantly waiting on port 2000
 * if someone wants to send file. All point of this class is
 * once someone wants to send file he will notify server about it over
 * this port and then server will send message to all Clients.
 * Once client receive message it automatically connect to port 1919
 * which is port for sending files.
 * @author vedad
 *
 */
public class FileConnectionListener extends Thread {

	private static int FILE_PORT;
	
	public FileConnectionListener(int PORT){
		this.FILE_PORT = PORT;
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(FILE_PORT);
			Socket client = ss.accept();
			System.out.println("PROSLO");
			new Message("SENDING_FILE","SERVER");		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
