package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import Modelo.ConectaServidor;
import Vistas.IVista;
import Vistas.PanelAvisoRecepcion;
import Vistas.PanelPrincipal;

public class Controlador implements ActionListener, Observer{

	private Thread servidor;
	private IVista vista;
	private ArrayList<IVista> panel = new ArrayList<IVista>();
	private ConectaServidor servicio;
	
	public Controlador () {
		this.vista = new PanelPrincipal();
		this.vista.setActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = (String) e.getActionCommand();
		
		
		if(accion.equals("Foco Incendio") || accion.equals("Seguridad") || accion.equals("Medico")) {
			String puerto = this.vista.getPuerto();
			String ip = this.vista.getIp();
			String puesto = this.vista.getPuesto();
			ip= ip.trim();
			if(puerto == null || puerto.equals("")) {
				this.vista.showMensaje("Ingrese un puerto");
			}else if(ip == null || ip.equals("") || ip.isEmpty()) {
				this.vista.showMensaje("Ingrese una IP");
			}else if(puesto == null || puesto.equals("") || puesto.trim().length() == 0) {
				this.vista.showMensaje("Ingrese un puesto");
			}else {
				Formatter fmtHora = new Formatter();
				Formatter fmtMins = new Formatter();
				Formatter fmtDia = new Formatter();
				Formatter fmtMes = new Formatter();
				Formatter fmtAno = new Formatter();
				String fecha = ""+fmtDia.format("%02d",LocalDateTime.now().getDayOfMonth())+"/"+fmtMes.format("%02d",LocalDateTime.now().getMonthValue())+"/"+
						fmtAno.format("%04d",LocalDateTime.now().getYear())+" - "+ fmtHora.format("%02d",LocalDateTime.now().getHour()) + ":" +fmtMins.format("%02d",LocalDateTime.now().getMinute());
				String mensaje = "emisor@" + accion + "@" + puesto + "@"+ fecha;
				servicio = new ConectaServidor(ip, Integer.parseInt(puerto), mensaje);
				this.panel.add(new PanelAvisoRecepcion(accion, puesto, puerto));
				
				this.servidor  = new Thread(servicio);
				servicio.addObserver(this);
				this.servidor.start();
			}
		}
		
	}
	@Override
	public void update(Observable o, Object arg) {
		String mensaje = (String) arg;
		
		if(mensaje.contains("rechazado")) {
			this.panel.get(this.panel.size()-1).showMensaje("Rechazado");
			this.panel.remove(this.panel.size()-1);
		}else if(mensaje.contains("reintento")){
			this.panel.get(this.panel.size()-1).showMensaje("Reintentando");
		}else if(mensaje.contains("noEnviado")){
			this.panel.get(this.panel.size()-1).showMensaje("No Enviado");
		}else if(mensaje.contains("reenviado")){
			this.panel.get(this.panel.size()-1).showMensaje("Reenviado");
		}else {
			int aux = mensaje.indexOf('@');
			String puerto = mensaje.substring(aux+1, mensaje.length());
			int i=0;
			while(i<this.panel.size() && !this.panel.get(i).getPuerto().equals(puerto)) {
				i++;
			}
			if(i < this.panel.size()) {
				this.panel.get(i).showMensaje("Recibido");
				this.panel.remove(i);
			}
		}
		
		
	}
	
}
