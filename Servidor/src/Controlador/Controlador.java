package Controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Conexion.ConectaReceptor;
import Conexion.Conectar;
import Modelo.Receptor;

public class Controlador implements Observer{
	
	private Conectar conexion;
	private ConectaReceptor conexionReceptor;
	private ArrayList<Receptor> receptores;
	private Thread t;
	
	

	public Controlador() {
		super();
		this.conexion = new Conectar();
		this.t = new Thread(this.conexion);
		this.t.start();
		this.receptores = new ArrayList<Receptor>();
	}



	@Override
	public void update(Observable o, Object arg) {
		String mensaje = (String) arg;
		System.out.println(mensaje);
		int aux = mensaje.indexOf('@');
		String app =  mensaje.substring(0, aux);
		String mens=mensaje.substring((mensaje.indexOf('@')+1), mensaje.length());
		String tipo= mens.substring(0, mens.indexOf('@'));
		if(app == "emisor") {
			
			int i;
			boolean aceptaReceptor;
			for(i=0; i<this.receptores.size(); i++) {
				aceptaReceptor = false;
				if(tipo == "Foco Incendio" && this.receptores.get(i).isFocoIncendio()) {
					aceptaReceptor= true;
				}else if(tipo == "Seguridad" && this.receptores.get(i).isSeguridad()) {
					aceptaReceptor= true;
				}else if(tipo == "Medico" && this.receptores.get(i).isAsistenciaMedica()){
					aceptaReceptor= true;
				}
				if(aceptaReceptor) {
					ConectaReceptor cp = new ConectaReceptor(this.receptores.get(i).getIp(), this.receptores.get(i).getPuerto(), mens);
					Thread t = new Thread(cp);
					cp.addObserver(this);
					t.start();
					
				}
			}
		}else {
			if(tipo.equals("Foco Incendio") || tipo.equals("Seguridad") || tipo.equals("Medico")) {
				//CONFIRMACION DE RECEPCION
				this.conexion.mandarMensajeReceptor(mens);
			}else {
				//mensaje: receptor@medico@seguridad@incendio@ip@puerto
				mens = mensaje.substring((mens.indexOf('@')+1), mens.length());
				String seguridad = mens.substring(0, (mens.indexOf('@')+1));
				mens = mensaje.substring((mens.indexOf('@')+1), mens.length());
				String incendio = mens.substring(0, (mens.indexOf('@')+1));
				mens = mensaje.substring((mens.indexOf('@')+1), mens.length());
				String ip = mens.substring(0, (mens.indexOf('@')+1));
				mens = mensaje.substring((mens.indexOf('@')+1), mens.length());
				String puerto = mens.substring(0, (mens.indexOf('@')+1));
				boolean medico = tipo.equals("true")? true : false;
				boolean inc = incendio.equals("true")? true : false;
				boolean seg = seguridad.equals("true")? true : false;
				int p = Integer.parseInt(puerto);
				Receptor receptor = new Receptor(inc, medico, seg, p, ip);
				this.receptores.add(receptor);
			}
		}
	}
}
