package Vistas;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class PanelReceptor extends JFrame implements IVista {

	private static PanelReceptor instance;
	private JPanel contentPane;
	private JPanel panel_2;
	private JPanel panel_5;
	private JPanel panel;
	private JLabel lblTipoDeSolicitud;
	private JPanel panel_1;
	private JTextField textField_tipo;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JTextField textField_hora;
	private JPanel panel_6;
	private JLabel lblNewLabel_1;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JButton btn_ConfirmarRecepcion;
	private JRadioButton rdbtnAsistenciaMedica;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_lugar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelReceptor frame = new PanelReceptor();
					frame.setVisible(true);
					ConectaServidor1 server= new ConectaServidor1();
					server.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
*/
		/*ConectaServidor1 server= new ConectaServidor1();
		server.start();*/

		/*new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(1233);

					while (true) {

						Socket soc = s.accept();
						PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

						String msg = in.readLine();

						PanelReceptor.getInstance().getFieldLugar(msg);
						System.out.println(msg);
						//PanelReceptor.getInstance().textFieldLugar.setText("toti");
					}

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}.start();*/

	//}

	

	/**
	 * Create the frame.
	 */
	public PanelReceptor() {
		setTitle("Receptor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 500, 600);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(5, 2, 0, 0));

		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		this.panel_2.setLayout(new BorderLayout(0, 0));

		this.lblNewLabel_2 = new JLabel("Solicitudes permitidas:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel_2.add(this.lblNewLabel_2);

		this.panel_5 = new JPanel();
		this.contentPane.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(3, 1, 0, 0));

		this.rdbtnAsistenciaMedica = new JRadioButton("Asistencia Medica");
		this.panel_5.add(this.rdbtnAsistenciaMedica);

		this.rdbtnNewRadioButton_1 = new JRadioButton("Personal de seguridad");
		this.panel_5.add(this.rdbtnNewRadioButton_1);

		this.rdbtnNewRadioButton_2 = new JRadioButton("Foco de incendio");
		this.panel_5.add(this.rdbtnNewRadioButton_2);

		this.panel = new JPanel();
		this.panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.lblTipoDeSolicitud = new JLabel("Tipo de Solicitud");
		this.lblTipoDeSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel.add(this.lblTipoDeSolicitud);

		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

		this.textField_tipo = new JTextField();
		this.textField_tipo.setEditable(false);
		this.textField_tipo.setColumns(20);
		this.textField_tipo.setBackground(Color.WHITE);
		this.panel_1.add(this.textField_tipo);

		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_3);
		this.panel_3.setLayout(new BorderLayout(0, 0));

		this.lblNewLabel = new JLabel("Hora");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_3.add(this.lblNewLabel);

		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_4);
		this.panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

		this.textField_hora = new JTextField();
		this.textField_hora.setEditable(false);
		this.textField_hora.setColumns(20);
		this.textField_hora.setBackground(Color.WHITE);
		this.panel_4.add(this.textField_hora);

		this.panel_6 = new JPanel();
		this.panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_6);
		this.panel_6.setLayout(new BorderLayout(0, 0));

		this.lblNewLabel_1 = new JLabel("Lugar");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_6.add(this.lblNewLabel_1);

		this.panel_7 = new JPanel();
		this.panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_7);
		this.panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
		
		this.textField_lugar = new JTextField();
		this.textField_lugar.setBackground(Color.WHITE);
		this.textField_lugar.setEditable(false);
		this.panel_7.add(this.textField_lugar);
		this.textField_lugar.setColumns(20);

		this.panel_8 = new JPanel();
		this.contentPane.add(this.panel_8);

		this.panel_9 = new JPanel();
		this.contentPane.add(this.panel_9);
		this.panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));

		this.btn_ConfirmarRecepcion = new JButton("Confirmar Recepcion");
		this.btn_ConfirmarRecepcion.setActionCommand("ConfirmarRecepcion");
		this.btn_ConfirmarRecepcion.setToolTipText("");
		this.btn_ConfirmarRecepcion.setForeground(Color.WHITE);
		this.btn_ConfirmarRecepcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btn_ConfirmarRecepcion.setBackground(Color.BLACK);
		this.panel_9.add(this.btn_ConfirmarRecepcion);
		this.setVisible(true);
		
	}

	public void getFieldLugar(String a) {
		System.out.println("estoy ");
		this.textField_lugar.setText(a);
	}

	@Override
	public void setActionListener(ActionListener a) {
		// TODO Auto-generated method stub
		this.btn_ConfirmarRecepcion.addActionListener(a);
	}

	@Override
	public void nuevoMensaje(String tipo, String hora, String lugar) {
		this.textField_tipo.setText(tipo);
		this.textField_hora.setText(hora);
		this.textField_lugar.setText(lugar);
		AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Vistas/sonido.wav"));
        sonido.play();
	}

	
	
}