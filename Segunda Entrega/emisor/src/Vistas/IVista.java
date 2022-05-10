package Vistas;

import java.awt.event.ActionListener;

public interface IVista {

	String getPuerto();
	String getIp();
	String getPuesto();
	
	void setActionListener(ActionListener a);
	void showMensaje(String mensaje);
	void visible(boolean visible);
}
