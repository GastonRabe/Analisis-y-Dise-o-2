package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Observable;

import javax.swing.JOptionPane;

import Vistas.IVista;
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
	private ArrayList<String> ins;
	private ArrayList<String> horas;
	
	private ServidorRecepcion () {
		this.outs = new ArrayList<PrintWriter>();
		this.ins = new ArrayList<String>();
		this.horas = new ArrayList<String>();
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
                this.ins.add(msg);
                Formatter fmtHora = new Formatter();
                Formatter fmtMins = new Formatter();
                int aux = msg.indexOf('@');
                this.tipo = msg.substring(0, aux);
                this.lugar = msg.substring(aux+1, msg.length());
                this.hora = fmtHora.format("%02d",LocalDateTime.now().getHour()) + ":" +fmtMins.format("%02d",LocalDateTime.now().getMinute());
                this.horas.add(hora);
                this.setChanged();
        		this.notifyObservers();
               
            }

        } catch (Exception e) {
            e.printStackTrace();
          
        }
	}

	public void mandarMensaje(String msg, IVista vent) {
		if(msg.equals("rechazado")) {
			this.outs.get(this.outs.size() -1).println(msg);
			this.outs.remove(this.outs.size() -1);
			this.ins.remove(this.ins.size() -1);
			this.horas.remove(this.ins.size() -1);
		}else {
			if (outs.size()>0)
			{
				this.outs.get(0).println(msg);
				this.outs.remove(0);
				this.ins.remove(0);
				this.horas.remove(0);
				
				if (outs.size()==0)
					vent.actualizarFields("","","");
				else
				{
					Formatter fmtHora = new Formatter();
	                Formatter fmtMins = new Formatter();
	                String mensaje=ins.get(0);
	                String hora=horas.get(0);
	                int aux = mensaje.indexOf('@');
	                vent.actualizarFields(mensaje.substring(0, aux), hora, mensaje.substring(aux+1, mensaje.length()));
				}
            
			} else JOptionPane.showMessageDialog(null, "No tiene notificaciones para confirmar");
            
			
			
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
