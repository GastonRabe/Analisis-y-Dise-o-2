package Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ConectaServidor extends Thread{

	@Override
	public void run() {
		try {
            ServerSocket s = new ServerSocket(1234);
            System.out.println("Escuchando");

            while (true) {

                Socket soc = s.accept();
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

                String msg = in.readLine();
               
                //PanelReceptor.getInstance().getFieldLugar().setText("lugar");
                System.out.println("holis");
            }

        } catch (Exception e) {
            e.printStackTrace();
          
        }
	}
}
