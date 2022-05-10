package Conexion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

public class ConectaReceptor extends Observable implements Runnable {

	private String mensaje, ip;
	private int puerto;
	private PrintWriter out;
	private BufferedReader in;
	private boolean bool = true;
	
	
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
			Socket socket = new Socket(this.ip, this.puerto);
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (this.bool) {
				this.out.println(this.mensaje);
				String mensaje = this.in.readLine();
				this.setChanged();
        		this.notifyObservers(mensaje+"@"+this.puerto);
				
				this.bool = false;
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
