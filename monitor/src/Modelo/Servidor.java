package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

public class Servidor extends Observable implements Runnable{

	private String ip, puerto;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;

	public Servidor(String ip, String puerto) {
		super();
		this.ip = ip;
		this.puerto = puerto;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.s = new Socket(ip, Integer.parseInt(this.puerto));
			this.out = new PrintWriter(s.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.out.println("Primario@"+Controlador.puertoReferencia);
			this.puerto = Controlador.puertoReferencia;
			this.s.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error"+ e.getMessage());
			this.setChanged();
            this.notifyObservers("HacerCambio");
			e.printStackTrace();
		}
	}
	
	
}
