package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Modelo.ServidorRecepcion;
import Vistas.IVista;
import Vistas.PanelReceptor;
import Vistas.VentanaConfiguracion;

public class Controlador implements ActionListener, Observer{
	
	private Thread hilo;
	private PanelReceptor ventana;
	private IVista ventanaConfig;
	
	
	public Controlador() {
		this.ventanaConfig = new VentanaConfiguracion();
		this.ventanaConfig.setActionListener(this);
		
		
		
		ServidorRecepcion.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand();
		if(accion.equals("ConfirmarRecepcion")) {
			
			ServidorRecepcion.getInstance().mandarMensaje(accion,ventana);
			
		}else if(accion.equals("Escuchar")) {
			//verificar que haya valores en los puertos, en la ip y que haya al menos un rdbtn seleccionado
			try {
				Socket s = new Socket(this.ventanaConfig.getIpServidor(), Integer.parseInt(this.ventanaConfig.getPuertoServidor()));
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				String medico = this.ventanaConfig.getRdbtnMedico()? "true":"false";
				String seguridad = this.ventanaConfig.getRdbtnSeguridad()? "true":"false";
				String incendio = this.ventanaConfig.getRdbtnIncendio()? "true":"false";
				String ip = "localhost";
				String puerto = this.ventanaConfig.getPuerto();
				String mensaje = "receptor@"+medico+"@"+seguridad+"@"+incendio+"@"+ip+"@"+puerto;
				out.println(mensaje);
				s.close();
				this.ventanaConfig.visible(false);
				this.ventana = new PanelReceptor(ventanaConfig.posicionX(), ventanaConfig.posicionY(),this.ventanaConfig.getRdbtnMedico(),
						this.ventanaConfig.getRdbtnIncendio(), this.ventanaConfig.getRdbtnSeguridad(), puerto);
				this.ventana.setActionListener(this);
				ServidorRecepcion.getInstance().setPuerto(Integer.parseInt(puerto));
				this.hilo = new Thread(ServidorRecepcion.getInstance());
				this.hilo.start();
				this.ventana.setBtnRecepcion(false);
				this.ventana.setBtnEscuchar(false);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String mensaje = (String) arg;
		if(o.equals(ServidorRecepcion.getInstance())) {
			String tipo = ServidorRecepcion.getInstance().getTipo();
			if(tipo.equals("RecepcionConfirmada")) {
				String aux = mensaje.substring(mensaje.indexOf('@')+1, mensaje.length());
				ServidorRecepcion.getInstance().eliminarConexion(aux, ventana);
			}else if((tipo.equals("Medico") && this.ventana.getRdbtnMedico()) || (tipo.equals("Foco Incendio") && this.ventana.getRdbtnIncendio()) || (tipo.equals("Seguridad") && this.ventana.getRdbtnSeguridad())) {
				this.ventana.nuevoMensaje(tipo, ServidorRecepcion.getInstance().getHora(), ServidorRecepcion.getInstance().getLugar());
				this.ventana.setBtnRecepcion(true);
			}else {
				ServidorRecepcion.getInstance().mandarMensaje("rechazado",ventana);
			}
		}
	}

	
}
