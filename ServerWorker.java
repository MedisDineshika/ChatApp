package com.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerWorker extends Thread {

	
	private final Socket clientSocket;

	public ServerWorker(Socket clientSocket) {
		this.clientSocket =clientSocket;
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void run() {
		try {
			clientSocketHandle();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void clientSocketHandle() throws IOException, InterruptedException {
		OutputStream outputStream = clientSocket.getOutputStream();
		for (int i = 0; i < 10; i++) {
			outputStream.write(("Time now is" + new Date() + "\n").getBytes());
			Thread.sleep(1000);

		}
	
}
}