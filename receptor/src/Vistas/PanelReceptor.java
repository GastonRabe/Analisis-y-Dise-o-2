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
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class PanelReceptor extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_2;
	private JRadioButton rdbtnAsistenciaMedica;
	private JRadioButton rdbtnSeguridad;
	private JRadioButton rdbtnIncendio;
	private JPanel panel_5;
	private JLabel lblTipoDeSolicitud_1;
	private JPanel panel;
	private JTextField textField_tipo;
	private JLabel lblNewLabel_2;
	private JTextField textField_hora;
	private JLabel lblNewLabel;
	private JTextField textField_lugar;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btn_ConfirmarRecepcion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JTextField textFieldPuerto;
	private JTextField textFieldIP;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	

	

	/**
	 * Create the frame.
	 */
	public PanelReceptor(int x, int y, boolean medico, boolean incendio, boolean seguridad, String puerto) {
		setTitle("Receptor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 500, 380);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel_10 = new JPanel();
		this.panel_10.setBounds(5, 7, 243, 93);
		this.contentPane.add(this.panel_10);
		this.panel_10.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("IP:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(10, 10, 57, 26);
		this.panel_10.add(this.lblNewLabel_1);
		
		this.lblNewLabel_4 = new JLabel("Puerto:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_4.setBounds(10, 46, 103, 28);
		this.panel_10.add(this.lblNewLabel_4);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setBounds(77, 17, 163, 20);
		this.panel_10.add(this.textFieldIP);
		this.textFieldIP.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldIP.setEditable(false);
		this.textFieldIP.setColumns(10);
		try {
			this.textFieldIP.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setBounds(77, 54, 163, 20);
		this.panel_10.add(this.textFieldPuerto);
		this.textFieldPuerto.setEditable(false);
		this.textFieldPuerto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPuerto.addKeyListener(this);
		this.textFieldPuerto.setColumns(10);
		this.textFieldPuerto.setText(puerto);
		
		this.panel_11 = new JPanel();
		this.panel_11.setBounds(248, 7, 243, 93);
		this.contentPane.add(this.panel_11);
		this.panel_11.setLayout(null);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBounds(0, 0, 243, 93);
		this.panel_11.add(this.panel_2);
		this.panel_2.setBorder(new TitledBorder(null, "Solicitudes Permitidas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.setLayout(null);
		
		this.rdbtnAsistenciaMedica = new JRadioButton("Asistencia Medica");
		this.rdbtnAsistenciaMedica.setEnabled(false);
		this.rdbtnAsistenciaMedica.setBounds(34, 11, 237, 30);
		this.panel_2.add(this.rdbtnAsistenciaMedica);
		
		this.rdbtnSeguridad = new JRadioButton("Personal de seguridad");
		this.rdbtnSeguridad.setEnabled(false);
		this.rdbtnSeguridad.setBounds(34, 35, 237, 30);
		this.panel_2.add(this.rdbtnSeguridad);
		
		this.rdbtnIncendio = new JRadioButton("Foco de incendio");
		this.rdbtnIncendio.setEnabled(false);
		this.rdbtnIncendio.setBounds(34, 58, 237, 30);
		this.panel_2.add(this.rdbtnIncendio);
		this.rdbtnAsistenciaMedica.setSelected(medico);
		this.rdbtnIncendio.setSelected(incendio);
		this.rdbtnSeguridad.setSelected(seguridad);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBounds(5, 100, 243, 93);
		this.contentPane.add(this.panel_5);
		this.panel_5.setLayout(null);
		
		this.lblTipoDeSolicitud_1 = new JLabel("Tipo de Solicitud");
		this.lblTipoDeSolicitud_1.setBounds(10, 8, 231, 25);
		this.lblTipoDeSolicitud_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.panel_5.add(this.lblTipoDeSolicitud_1);
		
		this.lblNewLabel_2 = new JLabel("Fecha y Hora");
		this.lblNewLabel_2.setBounds(10, 35, 231, 25);
		this.panel_5.add(this.lblNewLabel_2);
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.lblNewLabel = new JLabel("Lugar");
		this.lblNewLabel.setBounds(10, 61, 231, 25);
		this.panel_5.add(this.lblNewLabel);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.panel = new JPanel();
		this.panel.setBounds(248, 100, 243, 93);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.textField_tipo = new JTextField();
		this.textField_tipo.setBounds(22, 10, 186, 19);
		this.textField_tipo.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_tipo.setEditable(false);
		this.textField_tipo.setColumns(20);
		this.textField_tipo.setBackground(Color.WHITE);
		this.panel.add(this.textField_tipo);
		
		this.textField_hora = new JTextField();
		this.textField_hora.setBounds(22, 39, 186, 19);
		this.panel.add(this.textField_hora);
		this.textField_hora.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_hora.setEditable(false);
		this.textField_hora.setColumns(20);
		this.textField_hora.setBackground(Color.WHITE);
		
		this.textField_lugar = new JTextField();
		this.textField_lugar.setBounds(22, 68, 186, 19);
		this.panel.add(this.textField_lugar);
		this.textField_lugar.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_lugar.setEditable(false);
		this.textField_lugar.setColumns(20);
		this.textField_lugar.setBackground(Color.WHITE);
		
		this.panel_7 = new JPanel();
		this.panel_7.setBounds(5, 249, 486, 93);
		this.panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Historial de Solicitudes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(this.panel_7);
		this.panel_7.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_7.add(this.scrollPane);
		
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.scrollPane.setViewportView(this.textArea);
		
		this.panel_8 = new JPanel();
		this.panel_8.setBounds(116, 203, 243, 63);
		this.contentPane.add(this.panel_8);
		this.panel_8.setLayout(null);
		
		this.btn_ConfirmarRecepcion = new JButton("Confirmar Recepcion");
		this.btn_ConfirmarRecepcion.setEnabled(false);
		this.btn_ConfirmarRecepcion.setBounds(33, 10, 200, 29);
		this.btn_ConfirmarRecepcion.setToolTipText("");
		this.btn_ConfirmarRecepcion.setForeground(Color.BLACK);
		this.btn_ConfirmarRecepcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btn_ConfirmarRecepcion.setBackground(SystemColor.inactiveCaption);
		this.btn_ConfirmarRecepcion.setActionCommand("ConfirmarRecepcion");
		this.panel_8.add(this.btn_ConfirmarRecepcion);
		
		
		this.setAlwaysOnTop(true);
		this.textArea.append("Tipo de Solicitud:"+"\t"+"Lugar:"+"\t\t"+"Fecha y Hora:"+"\n\n");
		this.setVisible(true);
	}

	public void getFieldLugar(String a) {
		
		this.textField_lugar.setText(a);
	}

	@Override
	public void setActionListener(ActionListener a) {
		// TODO Auto-generated method stub
		this.btn_ConfirmarRecepcion.addActionListener(a);
		
	}

	@Override
	public void nuevoMensaje(String tipo, String hora, String lugar) {
		this.textArea.append(tipo+"\t\t"+lugar+"                        \t"+hora+"\n");
		if (textField_tipo.getText().equals("") || textField_hora.getText().equals("") || textField_lugar.getText().equals(""))
		{
			this.textField_tipo.setText(tipo);
			this.textField_hora.setText(hora);
			this.textField_lugar.setText(lugar);
		}
		
		AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Vistas/sonido.wav"));
        sonido.play();
	}
	
	@Override
	public void actualizarFields(String tipo, String hora, String lugar) {
		this.textField_tipo.setText(tipo);
		this.textField_hora.setText(hora);
		this.textField_lugar.setText(lugar);
		if(tipo.equals("")) {
			this.btn_ConfirmarRecepcion.setEnabled(false);
		}else
			this.btn_ConfirmarRecepcion.setEnabled(true);
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
	
	public void setBtnRecepcion(boolean a) {
		this.btn_ConfirmarRecepcion.setEnabled(a);
	}

	public void setBtnEscuchar(boolean a) {
		
	}

	@Override
	public String getIpServidor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPuertoServidor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visible(boolean a) {
		// TODO Auto-generated method stub
		this.setVisible(a);
	}

	@Override
	public int posicionX() {
		// TODO Auto-generated method stub
		return this.getX();
	}

	@Override
	public int posicionY() {
		// TODO Auto-generated method stub
		return this.getY();
	}
	
}