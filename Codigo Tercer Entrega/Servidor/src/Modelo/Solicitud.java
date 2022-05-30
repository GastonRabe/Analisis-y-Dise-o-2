package Modelo;

import java.io.PrintWriter;
import java.util.ArrayList;

import Conexion.ConectaReceptor;

public class Solicitud {

	private static int id=0;
	private int idReference;
	private PrintWriter out;
	private ArrayList<Receptor> outsReceptores;
	public Solicitud(PrintWriter out) {
		super();
		
		this.idReference = Solicitud.id++;
		this.out = out;
		this.outsReceptores = new ArrayList<Receptor>();
	}
	
	public void confirmarRecepcion(boolean ok) {
		if(ok) {
			this.out.println("ConfirmarRecepcion");
			for(int i=0; i<this.outsReceptores.size(); i++) {
				if(this.outsReceptores.get(i) != null) {
					ConectaReceptor cp = new ConectaReceptor(this.outsReceptores.get(i).getIp(), this.outsReceptores.get(i).getPuerto(), "RecepcionConfirmada@"+this.idReference);
					Thread t = new Thread(cp);
					t.start();
					}
			}
		}else {
			this.out.println("rechazado");
		}
	}
	
	public int getId() {
		return this.idReference;
	}
	
	public void addReceptor(Receptor o) {
		this.outsReceptores.add(o);
	}
}
