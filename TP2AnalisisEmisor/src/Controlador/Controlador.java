package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import Modelo.ConectaServidor;
import Vistas.IVista;
import Vistas.PanelAvisoRecepcion;
import Vistas.PanelPrincipal;

public class Controlador implements ActionListener, Observer{

	private Thread servidor;
	private IVista vista;
	private IVista panel;
	
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
				String mensaje = accion + "@" + puesto;
				ConectaServidor servicio = new ConectaServidor(ip, Integer.parseInt(puerto), mensaje);
				
				this.vista.visible(false);
				this.panel = new PanelAvisoRecepcion(accion, puesto);
				this.panel.setActionListener(this);
				this.servidor  = new Thread(servicio);
				servicio.addObserver(this);
				this.servidor.start();
				/*while(this.panel.isVisible()) {
					
				}
				this.vista.visible(true);*/
			}
		}else if(accion.equals("OK")) {
			this.panel.visible(false);
			this.vista.visible(true);
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		String mensaje = (String) arg;
		
		if(mensaje.equals("rechazado")) {
			this.panel.showMensaje("Rechazado");
		}else {
			this.panel.showMensaje("Recibido");
		}
		
		
	}
	
}
