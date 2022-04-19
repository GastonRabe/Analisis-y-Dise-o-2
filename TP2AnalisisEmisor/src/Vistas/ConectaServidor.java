package Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConectaServidor extends Thread{
	
	@Override
	public void run() {
		
		try {
            Socket socket = new Socket("192.168.0.88",1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("hola");//jTextArea1.getText());
            out.close();
            socket.close();
            //jTextArea1.setText("");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
