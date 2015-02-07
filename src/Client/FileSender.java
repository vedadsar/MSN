package Client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileSender extends Thread {	
	
	private final static int PORT = 1919;
	private OutputStream os;
	private String path;
	
	public FileSender(String path){
		this.path = path;
	}
	
	@Override
	public void run() {
		ServerSocket serverConnection;
		Socket clientConnection;
		try {
			
			serverConnection = new ServerSocket(PORT);	
			System.out.println("Waiting for client to accept connection ");
			clientConnection = serverConnection.accept();
		
			File file = new File(path);
			byte[] fileArray = new byte[(int)file.length()];
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			bis.read(fileArray);
			os = clientConnection.getOutputStream();
			System.out.println("Sending " +clientConnection);
			os.write(fileArray);
			os.flush();			
			System.out.println("DONE");
		
		} catch (UnknownHostException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
