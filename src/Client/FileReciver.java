package Client;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Server.Message;

public class FileReciver extends Thread {	

	private static final int PORT = 1919;
	private final static String HOST = "localhost";
	private final int FILE_SIZE = Integer.MAX_VALUE;
	private InputStream is;
	private final static String RECIVE_FILE = "C:/Users/vedad/Desktop";

	@Override
	public void run() {		
		
		int bytesRead;
		int current = 0;
		FileOutputStream fos = null; // Stream for saving file
		BufferedOutputStream bos = null; // Buffered stream for saving file.
		Socket sock = null;
		try {
			sock = new Socket(HOST, PORT);
			System.out.println("Connecting...");

			// receive file
			byte[] mybytearray = new byte[60000];
			InputStream is = sock.getInputStream();
			//fos = new FileOutputStream(RECIVE_FILE);
			//bos = new BufferedOutputStream(fos);
			bytesRead = is.read(mybytearray, 0, mybytearray.length);
			current = bytesRead;

			do {
				bytesRead = is.read(mybytearray, current,
						(mybytearray.length - current));
				if (bytesRead >= 0)
					current += bytesRead;
			} while (bytesRead > -1);

//			bos.write(mybytearray, 0, current);
//			bos.flush();
//			System.out.println("File " + RECIVE_FILE + " downloaded ("
//					+ current + " bytes read)");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("SENDING DONE");
		}

	}
}
