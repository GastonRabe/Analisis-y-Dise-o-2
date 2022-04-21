package Vistas;

import java.awt.event.ActionListener;

public interface IVista {

	void setActionListener(ActionListener a);
	
	void nuevoMensaje(String tipo, String hora, String lugar);
	
	
}
