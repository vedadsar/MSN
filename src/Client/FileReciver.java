package Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import Server.Message;
/**
 * Class which recive file over socket.
 * It extends thread so while file transfer is in process
 * user can continue chatting.
 * @author vedad
 *
 */
public class FileReciver extends Thread {	

	private static final int PORT = 1919;			//Port for files
	private final static String HOST = "localhost";
	private InputStream is;
	private Socket sock;
	
	@Override
	public void run() {				
	//	Socket sock ;
		try {
			sock = new Socket(HOST, PORT);		//Creating new connection
			System.out.println("Connecting...");
						
			byte[] fileArray = new byte[1024];	//byte array, file bytes		
			InputStream is = sock.getInputStream();	//getting input stream
						
		    FileOutputStream fos = new FileOutputStream("ID" +new Date().getTime()+".txt");	//path of file.		  
		    BufferedOutputStream bos = new BufferedOutputStream(fos);
		    int bytesRead ;
		    //While we're reading bytes we put them in file with
		    // buffered output stream. This way we save file
		    while((bytesRead =  is.read(fileArray)) > 0){
		    	 bos.write(fileArray, 0, bytesRead);		    	
		    }
		    
		    System.out.println("RECIVING DONE !");	
		    
		    bos.flush();
		    bos.close();
		    is.close();	
		    sock.close();
		    
							
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
