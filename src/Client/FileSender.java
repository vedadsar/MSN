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

import GUI.ChatGui;
import Server.Message;

/**
 * Class which will send file.
 * This class extends thread because we want sending file
 * runs in background on another thread. This means we'll
 * be able to continue chatting while file is sending.
 * @author vedad
 *
 */
public class FileSender extends Thread {	
	
	private final static int PORT = 1919;	//Port for sending files.
	private OutputStream os;
	private String path;		//Path of file that we want to send.
	
	public FileSender(String path){
		this.path = path;
	}
	
	/**
	 * Override of run method from thread. 
	 * Here I'll make client that runs this thread new server
	 * so once this client press send button on main server
	 * I'll send servers message that will be sent to all clients.
	 * Once client recive that message we'll make all clients run
	 * FileRecive class that will recive files.
	 */
	@Override
	public void run() {
		
		ServerSocket serverConnection;	//Socket from client that will actually become server when sending file.
		Socket clientConnection;		//Client connection once its accepted by server.
		try {
			
			serverConnection = new ServerSocket(PORT);	
			System.out.println("Waiting for client to accept connection ");
			clientConnection = serverConnection.accept();
		
			File file = new File(path);  //Creating file with desired path.
			//New byte array we'll send. It has file.lenght size.
			byte[] fileArray = new byte[(int)file.length()];
			//Buffered input stream, is actually stream that will read from file.
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));		
			bis.read(fileArray);
		
			os = clientConnection.getOutputStream();
			System.out.println("Sending " +clientConnection);
			os.write(fileArray);		//Sending File array to output stream.
			os.flush();			
			System.out.println("DONE");
			
			os.close();
			serverConnection.close();			
		
		} catch (UnknownHostException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			
		}
		
	}

}
