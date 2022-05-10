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
	private String tipo, hora, lugar;
	private int puerto=1234; 
	private ArrayList<PrintWriter> outs;
	private ArrayList<BufferedReader> insReceptor;
	private ArrayList<String> ins;
	private ArrayList<String> horas;
	
	
	
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(puerto);
			
			while(true) {
				System.out.println("ESPERANDO el socket");
				Socket soc = this.ss.accept();
				System.out.println("acepte el socket");
                this.out = new PrintWriter(soc.getOutputStream(), true);
                System.out.println("aaa");
                this.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                //this.outs.add(out);
                System.out.println("antes de leer");
                String msg = this.in.readLine();
                System.out.println("DESPUES de leer");
                this.setChanged();
                this.notifyObservers(msg);
                
			}
		}catch (Exception e) {
			
		}
		
	}
	
	public void mandarMensajeReceptor(String msg) {
		this.out.println(msg);
	}

	
}
