package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ConectarPrimario extends Observable implements Runnable{

	private ServerSocket ss;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private int puerto;

	
	public ConectarPrimario(int puerto) {
		this.puerto = puerto;
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println("3");
			this.ss = new ServerSocket(this.puerto);
			System.out.println("4");
			while(true) {
				
				this.s = this.ss.accept();
				this.out = new PrintWriter(this.s.getOutputStream(), true);
	            this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg);
			}
		}catch (Exception e) {
			
		}
	}
	
	public void cerrarSocket() {
		try {
			this.s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mandarMensaje(String msg) {
		System.out.println("mandar mensaje");
		this.out.println(msg);
	}

	public String getIp() {
		
		return this.s.getInetAddress().getHostName();
	}
	
	public int getPuerto() {
		return this.puerto;
	}
	
	public PrintWriter getOut() {
		return this.out;
	}
}
