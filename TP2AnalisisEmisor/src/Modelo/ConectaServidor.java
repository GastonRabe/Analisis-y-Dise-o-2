package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

public class ConectaServidor extends Observable implements Runnable {

	private PrintWriter out;
	private BufferedReader in;
	private boolean bool = true;
	private String ip, mensaje;
	private int puerto;

	public ConectaServidor(String ip, int puerto, String mensaje) {
		this.ip = ip;
		this.puerto = puerto;
		this.mensaje = mensaje;
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(this.ip, this.puerto);
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (this.bool) {
				this.out.println(mensaje);
				String mensaje = this.in.readLine();
				this.setChanged();
        		this.notifyObservers(mensaje);
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
