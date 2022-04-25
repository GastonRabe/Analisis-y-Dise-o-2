package Vistas;

import java.net.InetAddress;
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
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelReceptor extends JFrame implements IVista, KeyListener {

	private static PanelReceptor instance;
	private JPanel contentPane;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JRadioButton rdbtnAsistenciaMedica;
	private JRadioButton rdbtnSeguridad;
	private JRadioButton rdbtnIncendio;
	private JPanel panel_5;
	private JLabel lblTipoDeSolicitud_1;
	private JPanel panel;
	private JTextField textField_tipo;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JTextField textField_hora;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JPanel panel_6;
	private JTextField textField_lugar;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btn_ConfirmarRecepcion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JTextField textFieldPuerto;
	private JTextField textFieldIP;
	private JButton btn_escuchar;

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
		this.contentPane.setLayout(new GridLayout(6, 2, 0, 0));
		
		this.panel_10 = new JPanel();
		this.contentPane.add(this.panel_10);
		this.panel_10.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("IP:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(84, 10, 57, 26);
		this.panel_10.add(this.lblNewLabel_1);
		
		this.lblNewLabel_4 = new JLabel("Puerto:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_4.setBounds(71, 35, 103, 28);
		this.panel_10.add(this.lblNewLabel_4);
		
		this.panel_11 = new JPanel();
		this.contentPane.add(this.panel_11);
		this.panel_11.setLayout(null);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.addKeyListener(this);
		this.textFieldPuerto.setBounds(35, 40, 163, 20);
		this.panel_11.add(this.textFieldPuerto);
		this.textFieldPuerto.setColumns(10);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setEditable(false);
		this.textFieldIP.setBounds(35, 10, 163, 20);
		this.panel_11.add(this.textFieldIP);
		this.textFieldIP.setColumns(10);
		
		this.panel_12 = new JPanel();
		this.contentPane.add(this.panel_12);
		this.panel_12.setLayout(null);
		
		this.lblNewLabel_3 = new JLabel("Solicitudes permitidas:");
		this.lblNewLabel_3.setBounds(20, 22, 207, 46);
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel_12.add(this.lblNewLabel_3);
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		this.panel_2.setLayout(null);
		
		this.rdbtnAsistenciaMedica = new JRadioButton("Asistencia Medica");
		this.rdbtnAsistenciaMedica.setBounds(34, 0, 237, 30);
		this.panel_2.add(this.rdbtnAsistenciaMedica);
		
		this.rdbtnSeguridad = new JRadioButton("Personal de seguridad");
		this.rdbtnSeguridad.setBounds(34, 29, 237, 30);
		this.panel_2.add(this.rdbtnSeguridad);
		
		this.rdbtnIncendio = new JRadioButton("Foco de incendio");
		this.rdbtnIncendio.setBounds(34, 60, 237, 30);
		this.panel_2.add(this.rdbtnIncendio);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_5);
		this.panel_5.setLayout(null);
		
		this.lblTipoDeSolicitud_1 = new JLabel("Tipo de Solicitud");
		this.lblTipoDeSolicitud_1.setBounds(10, 40, 231, 25);
		this.lblTipoDeSolicitud_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_5.add(this.lblTipoDeSolicitud_1);
		
		this.panel = new JPanel();
		this.panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel);
		this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
		
		this.textField_tipo = new JTextField();
		this.textField_tipo.setEditable(false);
		this.textField_tipo.setColumns(20);
		this.textField_tipo.setBackground(Color.WHITE);
		this.panel.add(this.textField_tipo);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.lblNewLabel_2 = new JLabel("Hora");
		this.lblNewLabel_2.setBounds(10, 40, 231, 25);
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_1.add(this.lblNewLabel_2);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_3);
		this.panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
		
		this.textField_hora = new JTextField();
		this.textField_hora.setEditable(false);
		this.textField_hora.setColumns(20);
		this.textField_hora.setBackground(Color.WHITE);
		this.panel_3.add(this.textField_hora);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_4);
		this.panel_4.setLayout(null);
		
		this.lblNewLabel = new JLabel("Lugar");
		this.lblNewLabel.setBounds(10, 39, 231, 25);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_4.add(this.lblNewLabel);
		
		this.panel_6 = new JPanel();
		this.panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_6);
		this.panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
		
		this.textField_lugar = new JTextField();
		this.textField_lugar.setEditable(false);
		this.textField_lugar.setColumns(20);
		this.textField_lugar.setBackground(Color.WHITE);
		this.panel_6.add(this.textField_lugar);
		
		this.panel_7 = new JPanel();
		this.contentPane.add(this.panel_7);
		
		this.panel_8 = new JPanel();
		this.contentPane.add(this.panel_8);
		this.panel_8.setLayout(null);
		
		this.btn_ConfirmarRecepcion = new JButton("Confirmar Recepcion");
		this.btn_ConfirmarRecepcion.setBounds(29, 31, 200, 29);
		this.btn_ConfirmarRecepcion.setToolTipText("");
		this.btn_ConfirmarRecepcion.setForeground(Color.BLACK);
		this.btn_ConfirmarRecepcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btn_ConfirmarRecepcion.setBackground(Color.WHITE);
		this.btn_ConfirmarRecepcion.setActionCommand("ConfirmarRecepcion");
		this.panel_8.add(this.btn_ConfirmarRecepcion);
		this.setVisible(true);
		try {
			this.textFieldIP.setText(InetAddress.getLocalHost().getHostAddress());
			
			btn_escuchar = new JButton("Escuchar");
			btn_escuchar.setBounds(70, 65, 105, 21);
			this.panel_11.add(btn_escuchar);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getFieldLugar(String a) {
		System.out.println("estoy ");
		this.textField_lugar.setText(a);
	}

	@Override
	public void setActionListener(ActionListener a) {
		// TODO Auto-generated method stub
		this.btn_ConfirmarRecepcion.addActionListener(a);
		this.btn_escuchar.addActionListener(a);
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

	@Override
	public boolean getRdbtnMedico() {
		// TODO Auto-generated method stub
		return this.rdbtnAsistenciaMedica.isSelected();
	}

	@Override
	public boolean getRdbtnIncendio() {
		// TODO Auto-generated method stub
		return this.rdbtnIncendio.isSelected();
	}

	@Override
	public boolean getRdbtnSeguridad() {
		// TODO Auto-generated method stub
		return this.rdbtnSeguridad.isSelected();
	}

	@Override
	public String getPuerto() {
		// TODO Auto-generated method stub
		return textFieldPuerto.getText();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros)
        {
            e.consume();
        }

        if (textFieldPuerto.getText().trim().length() == 4) {
            e.consume();
        }
	}
}