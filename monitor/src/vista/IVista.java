package vista;

import java.awt.event.ActionListener;

public interface IVista {

	void setActionListener(ActionListener a);
	String getPuerto();
	void nuevoMensaje(String mensaje);
	void setStatusButton(boolean status);
}
