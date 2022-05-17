package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VentanaConfiguracion extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JTextField textField_puerto;
	private JTextField textField_1;
	private JButton btn_escuchar;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JRadioButton rdbtnAsistenciaMedica;
	private JRadioButton rdbtnSeguridad;
	private JRadioButton rdbtnIncendio;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_IpServidor;
	private JTextField textField_puertoServidor;



	/**
	 * Create the frame.
	 */
	public VentanaConfiguracion() {
		setTitle("Configuracion Receptor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBounds(5, 5, 213, 126);
		this.panel.setLayout(null);
		this.contentPane.add(this.panel);
		
		this.lblNewLabel = new JLabel("IP:");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setBounds(84, 10, 57, 26);
		this.panel.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("Puerto:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(71, 35, 103, 28);
		this.panel.add(this.lblNewLabel_1);
		
		this.lblNewLabel_3 = new JLabel("IP Servidor:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_3.setBounds(59, 65, 95, 22);
		this.panel.add(this.lblNewLabel_3);
		
		this.lblNewLabel_4 = new JLabel("Puerto Servidor:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_4.setBounds(42, 90, 132, 22);
		this.panel.add(this.lblNewLabel_4);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBounds(218, 5, 213, 126);
		this.panel_1.setLayout(null);
		this.contentPane.add(this.panel_1);
		
		this.textField_puerto = new JTextField();
		this.textField_puerto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_puerto.setColumns(10);
		this.textField_puerto.setBounds(35, 38, 163, 20);
		this.panel_1.add(this.textField_puerto);
		
		this.textField_1 = new JTextField();
		this.textField_1.setText("192.168.0.207");
		this.textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_1.setEditable(false);
		this.textField_1.setColumns(10);
		this.textField_1.setBounds(35, 10, 163, 20);
		this.panel_1.add(this.textField_1);
		
		this.textField_IpServidor = new JTextField();
		this.textField_IpServidor.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_IpServidor.setColumns(10);
		this.textField_IpServidor.setBounds(35, 66, 163, 20);
		this.panel_1.add(this.textField_IpServidor);
		
		this.textField_puertoServidor = new JTextField();
		this.textField_puertoServidor.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_puertoServidor.setColumns(10);
		this.textField_puertoServidor.setBounds(35, 94, 163, 20);
		this.panel_1.add(this.textField_puertoServidor);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBounds(5, 131, 213, 126);
		this.panel_2.setLayout(null);
		this.contentPane.add(this.panel_2);
		
		this.lblNewLabel_2 = new JLabel("Solicitudes permitidas:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_2.setBounds(20, 22, 207, 46);
		this.panel_2.add(this.lblNewLabel_2);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBounds(218, 131, 213, 126);
		this.panel_3.setLayout(null);
		this.contentPane.add(this.panel_3);
		
		this.rdbtnAsistenciaMedica = new JRadioButton("Asistencia Medica");
		this.rdbtnAsistenciaMedica.setBounds(34, 0, 237, 30);
		this.panel_3.add(this.rdbtnAsistenciaMedica);
		
		this.rdbtnSeguridad = new JRadioButton("Personal de seguridad");
		this.rdbtnSeguridad.setBounds(34, 29, 237, 30);
		this.panel_3.add(this.rdbtnSeguridad);
		
		this.rdbtnIncendio = new JRadioButton("Foco de incendio");
		this.rdbtnIncendio.setBounds(34, 60, 237, 30);
		this.panel_3.add(this.rdbtnIncendio);
		
		this.btn_escuchar = new JButton("Escuchar");
		this.btn_escuchar.setBounds(44, 96, 105, 21);
		this.panel_3.add(this.btn_escuchar);
		this.btn_escuchar.setBackground(SystemColor.inactiveCaption);
		this.setAlwaysOnTop(true);
		setVisible(true);
	}



	@Override
	public void setActionListener(ActionListener a) {
		// TODO Auto-generated method stub
		this.btn_escuchar.addActionListener(a);
	}



	@Override
	public void nuevoMensaje(String tipo, String hora, String lugar) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actualizarFields(String tipo, String hora, String lugar) {
		// TODO Auto-generated method stub
		
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
		return this.textField_puerto.getText();
	}



	@Override
	public String getIpServidor() {
		// TODO Auto-generated method stub
		return this.textField_IpServidor.getText();
	}



	@Override
	public String getPuertoServidor() {
		// TODO Auto-generated method stub
		return this.textField_puertoServidor.getText();
	}



	@Override
	public void setBtnRecepcion(boolean a) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setBtnEscuchar(boolean a) {
		// TODO Auto-generated method stub
		this.btn_escuchar.setEnabled(a);
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