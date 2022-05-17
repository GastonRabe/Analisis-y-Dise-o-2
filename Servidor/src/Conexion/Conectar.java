package Conexion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;

import Modelo.Receptor;

public class Conectar extends Observable implements Runnable{

	private ServerSocket ss;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private int puerto; 

	
	public Conectar(int puerto) {
		this.puerto = puerto;
	}
	
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(puerto);
			
			while(true) {
				this.s = this.ss.accept();
                this.out = new PrintWriter(s.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg);
                
			}
		}catch (Exception e) {
			
		}
	}
	
	public void mandarMensajeReceptor(String msg) {
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
