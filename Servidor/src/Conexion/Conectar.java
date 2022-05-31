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
	private boolean bool = true;

	
	public Conectar(int puerto, String ipMonitor, int puertoMonitor) {
		this.puerto = puerto;
		this.ipMonitor = ipMonitor;
		this.puertoMonitor = puertoMonitor;
	}
	
	
	@Override
	public void run() {
		try {
			this.s = new Socket(this.ipMonitor, this.puertoMonitor);
			this.out = new PrintWriter(s.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (bool) {
                this.out.println("nuevo@localhost@"+this.puerto);
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg);

               this.bool = false;
                 this.s.close();
                // jTextArea1.setText("");
            }
			ss = new ServerSocket(puerto);
			
			this.bool = true;
			while(this.bool) {
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
			this.bool = false;
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
