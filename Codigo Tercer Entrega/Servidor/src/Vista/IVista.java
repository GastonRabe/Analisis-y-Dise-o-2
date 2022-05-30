package Vista;

import java.awt.event.ActionListener;

public interface IVista {

	void setActionListener(ActionListener a);
	String getIp();
	int getPuerto();
	
	void nuevoMensaje(String mensaje);
	void setEnableButton(boolean b);
}
