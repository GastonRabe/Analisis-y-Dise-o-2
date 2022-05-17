package Modelo;

public class Receptor {

	private boolean focoIncendio, asistenciaMedica, seguridad;
	private int puerto;
	private String ip;
	public Receptor(boolean focoIncendio, boolean asistenciaMedica, boolean seguridad, int puerto, String ip) {
		super();
		this.focoIncendio = focoIncendio;
		this.asistenciaMedica = asistenciaMedica;
		this.seguridad = seguridad;
		this.puerto = puerto;
		this.ip = ip;
	}
	public boolean isFocoIncendio() {
		return focoIncendio;
	}
	public boolean isAsistenciaMedica() {
		return asistenciaMedica;
	}
	public boolean isSeguridad() {
		return seguridad;
	}
	public int getPuerto() {
		return puerto;
	}
	public String getIp() {
		return ip;
	}
	
	
	
}
