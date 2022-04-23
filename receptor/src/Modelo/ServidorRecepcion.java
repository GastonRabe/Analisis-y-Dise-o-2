package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Observable;

import Vistas.PanelReceptor;


public class ServidorRecepcion extends Observable implements Runnable{

	
	private ServerSocket ss;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private static ServidorRecepcion instance =null;
	private String tipo, hora, lugar;
	
	private ServidorRecepcion () {
		
	}
	
	public static ServidorRecepcion getInstance() {
		if(instance == null) {
			instance = new ServidorRecepcion();
		}
		return instance;
	}
	
	
	@Override
	public void run() {
		try {
            this.ss = new ServerSocket(1233);

            while (true) {

                Socket soc = this.ss.accept();
                this.out = new PrintWriter(soc.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

                String msg = this.in.readLine();
               
                int aux = msg.indexOf('@');
                this.tipo = msg.substring(0, aux);
                this.lugar = msg.substring(aux+1, msg.length());
                this.hora = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() ;
                this.setChanged();
        		this.notifyObservers();
            }

        } catch (Exception e) {
            e.printStackTrace();
          
        }
	}

	public void mandarMensaje(String msg) {
		this.out.println(msg);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
}
