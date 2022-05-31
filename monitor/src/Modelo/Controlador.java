package Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer{

	private ArrayList<Servidor> servidores;
	private ConectarMonitor conexion;
	private IVista ventana;
	private String puertoReferencia = "1000";
	private Ping ping;
	
	
	
	public Controlador() {
		this.servidores = new ArrayList<Servidor>();
		this.ventana = new Ventana();
		this.ventana.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if(accion.equals("Escuchar")) {
			int puerto = Integer.parseInt(this.ventana.getPuerto());
			this.ventana.setStatusButton(false);
			this.conexion = new ConectarMonitor(puerto);
			Thread t = new Thread(this.conexion);
			t.start();
			this.conexion.addObserver(this);
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String msg = (String) arg;
		
		//nuevo
		String tipo = msg.substring(0, msg.indexOf('@'));
		if(tipo.equals("nuevo")) {
			int i = msg.indexOf('@');
			msg = msg.substring(msg.indexOf('@')+1);
			String ip = msg.substring(0, msg.indexOf('@'));
			String puerto = msg.substring(msg.indexOf('@')+1);
			this.servidores.add(new Servidor(ip, puerto));
			if(this.servidores.size() == 1) {
				this.conexion.mandarMensaje("Primario@"+this.puertoReferencia);
				//this.ping = new Ping(ip, Integer.parseInt(this.puertoReferencia));
			}else {
				this.conexion.mandarMensaje("Secundario");
			}
		}else {
			
		}
	}
	
	
}
