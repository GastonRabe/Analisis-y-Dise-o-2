package Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConectaServidor extends Thread {

	private PrintWriter out;
	private BufferedReader in;
	private boolean bool = true;

	public ConectaServidor() {

		/*
		 * try { Socket socket = new Socket("localhost",1233); this.out = new
		 * PrintWriter(socket.getOutputStream(), true); this.in = new BufferedReader(new
		 * InputStreamReader(socket.getInputStream())); out.println("hola@h");
		 * out.close();
		 * 
		 * //socket.close(); //jTextArea1.setText("");
		 * 
		 * } catch (Exception ee) { ee.printStackTrace(); }
		 */
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket("localhost", 1233);
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (this.bool) {
				this.out.println("hola@h");
				String mensaje = this.in.readLine();
				System.out.println(mensaje);
				this.bool = false;
				// socket.close();
				// jTextArea1.setText("");
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
