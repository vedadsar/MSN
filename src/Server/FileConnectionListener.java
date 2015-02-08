package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
