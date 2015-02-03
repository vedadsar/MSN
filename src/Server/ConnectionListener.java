package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConnectionListener extends Thread {

	private InputStream is;
	private String sender;

	// KONSTRUKTOR
	public ConnectionListener(InputStream is, String sender) {
		this.is = is;
		this.sender = sender;
	}

	@Override
	public void run() {
		BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		try {
			String str = "";

			while ((str = bf.readLine()) != null) {
				if(!str.equals("")){
					new Message(str, sender); 
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
