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
	private boolean bool = true;
	
	public Ping(String ip, int puerto2) {
		this.ip = ip;
		this.puerto = puerto2;
	}
	
	@Override
	public void run() {
		try {
			this.s = new Socket(this.ip, this.puerto);
			this.out = new PrintWriter(s.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                //this.out.println("Ping");
                String msg = this.in.readLine();
                this.setChanged();
                this.notifyObservers(msg+"@"+this.puerto);

                this.bool = false;
                // socket.close();
                // jTextArea1.setText("");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mandarPing(String mensaje) {
		this.out.println("Ping");
	}
}
