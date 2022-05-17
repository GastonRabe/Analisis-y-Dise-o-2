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
	private PrintWriter out;
	private BufferedReader in;
	private static ServidorRecepcion instance =null;
	private String tipo, hora, lugar, id;
	private int puerto;
	private ArrayList<PrintWriter> outs;
	private ArrayList<String> ins;
	private ArrayList<String> horas;
	private ArrayList<String> ids;
	
	private ServidorRecepcion () {
		this.outs = new ArrayList<PrintWriter>();
		this.ins = new ArrayList<String>();
		this.horas = new ArrayList<String>();
		this.ids = new ArrayList<String>();
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
                String msg = this.in.readLine();
                
                Formatter fmtHora = new Formatter();
                Formatter fmtMins = new Formatter();
                int aux = msg.indexOf('@');
                this.tipo = msg.substring(0, aux);
                if(!tipo.equals("RecepcionConfirmada")) {
                	this.ins.add(msg);
	                msg = msg.substring(aux+1, msg.length());
	                this.lugar = msg.substring(0, msg.indexOf('@'));
	                msg = msg.substring(msg.indexOf('@')+1, msg.length());
	                this.hora = msg.substring(0,msg.indexOf('@'));
	                this.outs.add(out);
	                
	                this.id = msg.substring(msg.indexOf('@')+1, msg.length());
	                this.ids.add(this.id);
	                this.horas.add(hora);
                }
                this.setChanged();
        		this.notifyObservers(msg);
               
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
			this.horas.remove(this.horas.size() -1);
		}else {
			if (outs.size()>0)
			{
				this.outs.get(0).println(msg+"@"+this.ids.get(0));
				this.outs.remove(0);
				this.ins.remove(0);
				this.horas.remove(0);
				this.ids.remove(0);
				if (outs.size()==0)
					vent.actualizarFields("","","");
				else
				{
					Formatter fmtHora = new Formatter();
	                Formatter fmtMins = new Formatter();
	                String mensaje=ins.get(0);
	                String hora=horas.get(0);
	                int aux = mensaje.indexOf('@');
	                String tipo = mensaje.substring(0, aux);
	                mensaje = mensaje.substring(aux+1, mensaje.length());
	                vent.actualizarFields(tipo, hora, mensaje.substring(0, mensaje.indexOf('@')));
				}
            
			} 
            
			
			
		}
		
	}
	
	public void eliminarConexion(String id, IVista vent) {
		int i=0;
		while(i<this.ids.size() && !this.ids.get(i).equals(id)) {
			i++;
		}
		if(i<this.ids.size() && i==0) {
			this.outs.get(0).println("cerrado");
			this.outs.remove(0);
			this.ins.remove(0);
			this.horas.remove(0);
			this.ids.remove(0);
			if (outs.size()==0) {
				vent.actualizarFields("","","");
			}
			else
			{
				Formatter fmtHora = new Formatter();
                Formatter fmtMins = new Formatter();
                String mensaje=ins.get(0);
                String hora=horas.get(0);
                int aux = mensaje.indexOf('@');
                String tipo = mensaje.substring(0, aux);
                mensaje = mensaje.substring(aux+1, mensaje.length());
                vent.actualizarFields(tipo, hora, mensaje.substring(0, mensaje.indexOf('@')));
			}
		}else if(i<this.ids.size()) {
			this.outs.get(i).println("cerrado");
			this.ids.remove(i);
			this.horas.remove(i);
			this.ins.remove(i);
			this.outs.remove(i);
		}
	}
	
	public String getId() {
		return this.id;
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
