package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ConectarMonitor extends Observable implements Runnable{

	private ServerSocket ss;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private int puerto;
	
	
	public ConectarMonitor(int puerto) {
		this.puerto = puerto;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
	
	public void mandarMensaje(String mensaje) {
		this.out.println(mensaje);
	}
	
}
