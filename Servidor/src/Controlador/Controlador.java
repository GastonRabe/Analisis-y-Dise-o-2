package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Observable;
import java.util.Observer;

import Conexion.ConectaReceptor;
import Conexion.Conectar;
import Modelo.Receptor;
import Modelo.Solicitud;
import Vista.IVista;
import Vista.ventanaServidor;

public class Controlador implements Observer, ActionListener{
	
	private Conectar conexion;
	private ConectaReceptor cp;
	private ArrayList<Receptor> receptores;
	private Thread t;
	private IVista ventana;
	private ArrayList<Solicitud> solicitudes;
	

	public Controlador() {
		super();
		this.ventana = new ventanaServidor();
		this.ventana.setActionListener(this);
		this.ventana.nuevoMensaje("Fecha y Hora:\t\tAccion:\t\t\tIP:\tPuerto:\n");
		this.receptores = new ArrayList<Receptor>();
		this.solicitudes = new ArrayList<Solicitud>();
	}



	@Override
	public void update(Observable o, Object arg) {
		Formatter fmtHora = new Formatter();
		Formatter fmtMins = new Formatter();
		Formatter fmtDia = new Formatter();
		Formatter fmtMes = new Formatter();
		Formatter fmtAno = new Formatter();
		String fecha = fmtDia.format("%02d",LocalDateTime.now().getDayOfMonth())+"/"+fmtMes.format("%02d",LocalDateTime.now().getMonthValue())+"/"+
				fmtAno.format("%04d",LocalDateTime.now().getYear())+" - "+ fmtHora.format("%02d",LocalDateTime.now().getHour()) + ":" +fmtMins.format("%02d",LocalDateTime.now().getMinute());
		
		String mensaje = (String) arg;
		int aux = mensaje.indexOf('@');
		String app =  mensaje.substring(0, aux);
		String mens=mensaje.substring((mensaje.indexOf('@')+1), mensaje.length());
		String tipo= mens.substring(0, mens.indexOf('@'));
		if(app.equals("emisor")) {
			//mensaje: emisor@tipoSolicitud@lugar@hora
			mensaje = mens;
			mens = mens.substring((mens.indexOf('@')+1), mens.length());
			String lugar = mens.substring(0, mens.indexOf('@'));
			String hora = mens.substring((mens.indexOf('@')+1), mens.length());
			
			int i;
			boolean aceptaReceptor;
			boolean hayReceptores = false;
			Solicitud solicitud = new Solicitud(this.conexion.getOut());
			this.ventana.nuevoMensaje(hora + "\t"+ "Solicitud "+ solicitud.getId()+": "+tipo +" en " + lugar+"\t\t" + this.conexion.getIp() + "\t"+ this.conexion.getPuerto());
			this.solicitudes.add(solicitud);
			this.ventana.nuevoMensaje(hora+ "\t"+ "Enviando solicitud a:\t\t");
			for(i=0; i<this.receptores.size(); i++) {
				aceptaReceptor = false;
				
				if(tipo.equals("Foco Incendio") && this.receptores.get(i).isFocoIncendio()) {
					aceptaReceptor= true;
				}else if(tipo.equals("Seguridad") && this.receptores.get(i).isSeguridad()) {
					aceptaReceptor= true;
				}else if(tipo.equals("Medico") && this.receptores.get(i).isAsistenciaMedica()){
					aceptaReceptor= true;
				}
				if(aceptaReceptor) {
					this.cp = new ConectaReceptor(this.receptores.get(i).getIp(), this.receptores.get(i).getPuerto(), mensaje+"@"+solicitud.getId());
					Thread t = new Thread(this.cp);
					this.cp.addObserver(this);
					t.start();
					solicitud.addReceptor(this.receptores.get(i));
					this.ventana.nuevoMensaje("\t\t\t\t\t"+ this.receptores.get(i).getIp()+ "\t"+ this.receptores.get(i).getPuerto());
					hayReceptores = true;
				}
			}
			if(!hayReceptores) {
				this.ventana.nuevoMensaje("RECHAZADO: no hay receptores que atiendan solicitud: "+ tipo);
				solicitud.confirmarRecepcion(false);
			}
		}else {
			if(tipo.equals("ConfirmarRecepcion")) {
				//CONFIRMACION DE RECEPCION
				
				String id = mens.substring((mens.indexOf('@')+1), mens.length());
				int idSol = Integer.parseInt(id);
				int i=0;
				while(i<this.solicitudes.size() && idSol != this.solicitudes.get(i).getId()) {
					i++;
				}
				this.ventana.nuevoMensaje(fecha+ "\tSolicitud "+ this.solicitudes.get(i).getId()+" confirmada");
				this.solicitudes.get(i).confirmarRecepcion(true);
				
			}else {
				//mensaje: receptor@medico@seguridad@incendio@ip@puerto
				mens = mens.substring((mens.indexOf('@')+1), mens.length());
				String seguridad = mens.substring(0, (mens.indexOf('@')));
				mens = mens.substring((mens.indexOf('@')+1), mens.length());
				String incendio = mens.substring(0, (mens.indexOf('@')));
				mens = mens.substring((mens.indexOf('@')+1), mens.length());
				String ip = mens.substring(0, (mens.indexOf('@')));
				mens = mens.substring((mens.indexOf('@')+1), mens.length());
				String puerto = mens;
				boolean medico = tipo.equals("true")? true : false;
				boolean inc = incendio.equals("true")? true : false;
				boolean seg = seguridad.equals("true")? true : false;
				int p = Integer.parseInt(puerto);
				Receptor receptor = new Receptor(inc, medico, seg, p, ip);
				this.receptores.add(receptor);
				String nuevoMens = fecha + "\t"+ "Registro Receptor"+ "\t\t" + ip + "\t"+ puerto;
				this.ventana.nuevoMensaje(nuevoMens);
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String aux = e.getActionCommand();
		
		if(aux.equals("Escuchar")) {
			this.ventana.setEnableButton(false);
			this.conexion = new Conectar(this.ventana.getPuerto());
			this.conexion.addObserver(this);
			this.t = new Thread(this.conexion);
			this.t.start();
		}
	}
}
