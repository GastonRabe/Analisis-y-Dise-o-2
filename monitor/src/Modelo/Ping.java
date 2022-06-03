package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

public class Ping extends Observable implements Runnable{

	
	private String ip;
	private int puerto;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	
	public Ping(String ip, int puerto2) {
		this.ip = ip;
		this.puerto = puerto2;
	}
	
	@Override
	public void run() {
		try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            while (true) {
            	this.s = new Socket(this.ip, this.puerto);
    			this.out = new PrintWriter(s.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                this.out.println("Ping");
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg);
                this.s.close();
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		} catch (IOException e) {
			this.setChanged();
            this.notifyObservers("HacerCambio");
		}
	}

	public void mandarPing() {
		this.out.println("Ping");
	}
}
