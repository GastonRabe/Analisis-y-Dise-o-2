package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

import Modelo.Solicitud;

public class ConectaReceptor extends Observable implements Runnable {

	private String mensaje, ip;
	private int puerto;
	private PrintWriter out;
	private BufferedReader in;
	private boolean bool = true;
	private Socket socket;
	
	
	public ConectaReceptor(String ip, int puerto, String mensaje) {
		super();
		this.mensaje = mensaje;
		this.ip = ip;
		this.puerto = puerto;
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.socket = new Socket(this.ip, this.puerto);
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while (this.bool) {
				this.out.println(this.mensaje);
				if(this.mensaje.contains("RecepcionConfirmada")) {
					this.cerrarSocket();
					
				}else {
					String msg = this.in.readLine();
					if(!msg.equals("cerrado")) {
						this.setChanged();
		        		this.notifyObservers("receptor@"+msg);
					}
	        		this.cerrarSocket();
				}
				this.bool = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarSocket() {
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
