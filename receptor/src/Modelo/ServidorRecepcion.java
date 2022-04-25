package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Observable;

import Vistas.PanelReceptor;


public class ServidorRecepcion extends Observable implements Runnable{

	
	private ServerSocket ss;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private static ServidorRecepcion instance =null;
	private String tipo, hora, lugar;
	private int puerto;
	private ArrayList<PrintWriter> outs;
	
	private ServidorRecepcion () {
		this.outs = new ArrayList<PrintWriter>();
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
            this.ss = new ServerSocket(this.puerto);

            while (true) {

                Socket soc = this.ss.accept();
                this.out = new PrintWriter(soc.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                this.outs.add(out);
                String msg = this.in.readLine();
                Formatter fmt = new Formatter();
                int aux = msg.indexOf('@');
                this.tipo = msg.substring(0, aux);
                this.lugar = msg.substring(aux+1, msg.length());
                this.hora = fmt.format("%02d",LocalDateTime.now().getHour()) + ":" + fmt.format("%02d",LocalDateTime.now().getMinute()) ;
                this.setChanged();
        		this.notifyObservers();
               
            }

        } catch (Exception e) {
            e.printStackTrace();
          
        }
	}

	public void mandarMensaje(String msg) {
		if(msg.equals("rechazado")) {
			this.outs.get(this.outs.size() -1).println(msg);
			this.outs.remove(this.outs.size() -1);
		}else {
			this.outs.get(0).println(msg);
			this.outs.remove(0);
		}
		
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
	
	public int getPuerto() {
		return this.puerto;
	}
	
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
}
