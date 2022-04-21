package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import Modelo.ServidorRecepcion;
import Vistas.PanelReceptor;

public class Controlador implements ActionListener, Observer{
	
	private Thread hilo;
	private PanelReceptor ventana;
	
	
	public Controlador() {
		this.ventana = new PanelReceptor();
		this.ventana.setActionListener(this);
		this.hilo = new Thread(ServidorRecepcion.getInstance());
		this.hilo.start();
		ServidorRecepcion.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand();
		
		if(accion.equals("ConfirmarRecepcion")) {
			ServidorRecepcion.getInstance().mandarMensaje(accion);
			//System.out.println("envio");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String mensaje = (String) arg;
		if(o.equals(ServidorRecepcion.getInstance())) {
			this.ventana.nuevoMensaje(ServidorRecepcion.getInstance().getTipo(), ServidorRecepcion.getInstance().getHora(), ServidorRecepcion.getInstance().getLugar());
		}
	}

	
}
