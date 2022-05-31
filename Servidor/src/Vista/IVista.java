package Vista;

import java.awt.event.ActionListener;

public interface IVista {

	void setActionListener(ActionListener a);
	String getIp();
	int getPuerto();
	String getIpMonitor();
	int getPuertoMonitor();
	void setStatus(String status);
	void setPuerto(String puerto);
	void nuevoMensaje(String mensaje);
	void setEnableButton(boolean b);
}
