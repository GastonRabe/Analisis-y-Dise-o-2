package Modelo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer{

	private ArrayList<Servidor> servidores;
	private ConectarMonitor conexion;
	private IVista ventana;
	static String puertoReferencia = "1000";
	private Ping ping;
	private Thread tPing;
	
	
	
	public Controlador() {
		this.servidores = new ArrayList<Servidor>();
		this.ventana = new Ventana();
		this.ventana.setActionListener(this);
		//this.timer= new Timer(3000, this);
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
		if(msg.equals("Eco")) {
			try {
				this.tPing.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(msg.equals("HacerCambio") && this.servidores.size() >0){
			this.ventana.nuevoMensaje("FALLO EN EL SERVIDOR PRIMARIO \tIP: "+ this.servidores.get(0).getIp() + "\tPUERTO: "+ this.servidores.get(0).getPuerto());
			this.servidores.remove(0);
			if(this.servidores.size() >0) {
				this.ventana.nuevoMensaje("REEMPLAZADO POR SERVIDOR \tIP: "+ this.servidores.get(0).getIp() + "\tPUERTO: "+ this.servidores.get(0).getPuerto());
				Thread t = new Thread(this.servidores.get(0));
				t.start();
				this.ping = new Ping(this.servidores.get(0).getIp(), Integer.parseInt(this.puertoReferencia));
				this.ping.addObserver(this);
				this.tPing = new Thread(this.ping);
				this.tPing.start();
			}else {
				this.ventana.nuevoMensaje("NO HAY SERVIDORES PARA REEMPLAZARLO");
			}
		}else {
			String tipo = msg.substring(0, msg.indexOf('@'));
			if(tipo.equals("nuevo")) { //NUEVO SERVIDOR
				int i = msg.indexOf('@');
				msg = msg.substring(msg.indexOf('@')+1);
				String ip = msg.substring(0, msg.indexOf('@'));
				String puerto = msg.substring(msg.indexOf('@')+1);
				Servidor s = new Servidor(ip, puerto);
				s.addObserver(this);
				this.servidores.add(s);
				if(this.servidores.size() == 1) {
					this.ventana.nuevoMensaje("NUEVO SERVIDOR ESTADO: PRIMARIO\tIP: "+ ip +  "\tPUERTO: "+ Controlador.puertoReferencia );
					s.setPuerto(Controlador.puertoReferencia);
					this.conexion.mandarMensaje("Primario@"+this.puertoReferencia);
					this.ping = new Ping(ip, Integer.parseInt(this.puertoReferencia));
					this.ping.addObserver(this);
					this.tPing = new Thread(this.ping);
					this.tPing.start();
				}else {
					this.ventana.nuevoMensaje("NUEVO SERVIDOR ESTADO: SECUNDARIO\tIP: "+ ip +  "\tPUERTO: "+ puerto );
					this.conexion.mandarMensaje("Secundario");
				}
			}else if(tipo.equals("sincronizar")){
				for(int i=1; i<this.servidores.size(); i++){
					try {
						Socket s = new Socket(this.servidores.get(i).getIp(), Integer.parseInt(this.servidores.get(i).getPuerto()));
						PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
						out.println(msg);
						s.close();
					} catch (IOException e) {
						this.servidores.remove(i);
					}
				}
			}
		}
	}
	
	
}
