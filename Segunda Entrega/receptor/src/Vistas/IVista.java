package Vistas;

import java.awt.event.ActionListener;

public interface IVista {

	void setActionListener(ActionListener a);
	
	void nuevoMensaje(String tipo, String hora, String lugar);
	void actualizarFields(String tipo, String hora, String lugar);
	
	boolean getRdbtnMedico();
	boolean getRdbtnIncendio();
	boolean getRdbtnSeguridad();
	String getPuerto();
	void setBtnRecepcion(boolean a);
	void setBtnEscuchar(boolean a);
}
