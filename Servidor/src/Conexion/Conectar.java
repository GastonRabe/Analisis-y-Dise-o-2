package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
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
	private int puerto, puertoMonitor; 
	private String ipMonitor;

	
	public Conectar(int puerto, String ipMonitor, int puertoMonitor) {
		this.puerto = puerto;
		this.ipMonitor = ipMonitor;
		this.puertoMonitor = puertoMonitor;
	}
	
	
	@Override
	public void run() {
		try {
			boolean bool = true;
			this.s = new Socket(this.ipMonitor, this.puertoMonitor);
			this.out = new PrintWriter(s.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (bool) {
                this.out.println("nuevo@localhost@"+this.puerto);
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg);

               bool = false;
                 this.s.close();
                // jTextArea1.setText("");
            }
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
	
	public void cerrarSocket() {
		try {
			this.s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
