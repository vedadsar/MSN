package Client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileSender extends Thread {
	
	
	private final static String HOST = "localhost";
	private final static int PORT = 1919;
	private OutputStream os;
	private String path;
	
	public FileSender(String path){
		this.path = path;
	}
	
	@Override
	public void run() {
		try {
			Socket fileSend = new Socket(HOST, PORT);			
			os = fileSend.getOutputStream();
			File file = new File(path);
			byte[] fileArray = new byte[(int)file.length()];
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			bis.read(fileArray);
			OutputStream os = fileSend.getOutputStream();
			os.flush();			
			
		
		} catch (UnknownHostException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
