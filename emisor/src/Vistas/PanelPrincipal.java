package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import Modelo.ConectaServidor;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelPrincipal extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JTextField textFieldPuesto;
	private JButton btn_solicitarIncendio;
	private JButton btn_solicitarSeguridad;
	private JPanel panel_7;

	private JTextField textFieldPuerto;
	private JTextField textFieldIP;
	private JButton btn_solicitarMedico;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}*/

	/**
	 * Create the frame.
	 */
	public PanelPrincipal() {
		setTitle("Emisor");
		setForeground(SystemColor.infoText);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.BLACK);
		this.contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal);
		this.panelPrincipal.setLayout(null);
		
		this.panel_7 = new JPanel();
		this.panel_7.setBounds(0, 0, 430, 139);
		this.panelPrincipal.add(this.panel_7);
		this.panel_7.setLayout(null);
		
		this.textFieldPuesto = new JTextField();
		this.textFieldPuesto.addKeyListener(this);
		this.textFieldPuesto.setName("fieldPuesto");
		this.textFieldPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPuesto.setBounds(230, 54, 171, 20);
		this.panel_7.add(this.textFieldPuesto);
		this.textFieldPuesto.setColumns(10);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setName("fieldPuerto");
		this.textFieldPuerto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPuerto.addKeyListener(this);
		this.textFieldPuerto.setBounds(230, 32, 171, 20);
		this.panel_7.add(this.textFieldPuerto);
		this.textFieldPuerto.setColumns(10);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setBounds(230, 11, 171, 20);
		this.panel_7.add(this.textFieldIP);
		this.textFieldIP.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldIP.setColumns(10);
		
		this.btn_solicitarSeguridad = new JButton("Seguridad");
		this.btn_solicitarSeguridad.setBounds(150, 98, 130, 30);
		this.panel_7.add(this.btn_solicitarSeguridad);
		this.btn_solicitarSeguridad.setActionCommand("Seguridad");
		
		this.btn_solicitarSeguridad.setForeground(Color.BLACK);
		this.btn_solicitarSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btn_solicitarSeguridad.setBackground(SystemColor.inactiveCaption);
		
		this.btn_solicitarIncendio = new JButton("Foco de Incendio");
		this.btn_solicitarIncendio.setBounds(290, 98, 130, 30);
		this.panel_7.add(this.btn_solicitarIncendio);
		this.btn_solicitarIncendio.setActionCommand("Foco Incendio");
		this.btn_solicitarIncendio.setForeground(Color.BLACK);
		this.btn_solicitarIncendio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.btn_solicitarIncendio.setBackground(SystemColor.inactiveCaption);
		
		btn_solicitarMedico = new JButton("Asistencia Medica");
		this.btn_solicitarMedico.setBounds(10, 98, 130, 30);
		this.panel_7.add(this.btn_solicitarMedico);
		this.btn_solicitarMedico.setActionCommand("Medico");
		btn_solicitarMedico.setForeground(Color.BLACK);
		btn_solicitarMedico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_solicitarMedico.setBackground(SystemColor.inactiveCaption);
		
		this.lblNewLabel = new JLabel("Puesto de trabajo:");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel.setBounds(43, 54, 195, 25);
		this.panel_7.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("(Campos obligatorios)");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.lblNewLabel_1.setBounds(262, 72, 135, 25);
		this.panel_7.add(this.lblNewLabel_1);
		
		this.lblNewLabel_2 = new JLabel("IP:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_2.setBounds(86, 11, 46, 14);
		this.panel_7.add(this.lblNewLabel_2);
		
		this.lblNewLabel_3 = new JLabel("Puerto:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_3.setBounds(74, 32, 118, 25);
		this.panel_7.add(this.lblNewLabel_3);
		
		setVisible(true);
		setAlwaysOnTop(true);
	}

	@Override
	public String getPuerto() {
		// TODO Auto-generated method stub
		return this.textFieldPuerto.getText();
	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return this.textFieldIP.getText();
	}

	@Override
	public String getPuesto() {
		// TODO Auto-generated method stub
		return this.textFieldPuesto.getText();
	}

	@Override
	public void setActionListener(ActionListener a) {
		this.btn_solicitarIncendio.addActionListener(a);
		this.btn_solicitarMedico.addActionListener(a);
		this.btn_solicitarSeguridad.addActionListener(a);
		
	}

	@Override
	public void showMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		
	}
	
	public void visible(boolean visible) {
		this.setVisible(visible);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getComponent().getName().equals("fieldPuerto"))
		{
			int key = e.getKeyChar();
	
	        boolean numeros = key >= 48 && key <= 57;
	
	        if (!numeros)
	        {
	            e.consume();
	        }
	
	        
	        if (textFieldPuerto.getText().trim().length() == 4) {
	            e.consume();
	        }
		} else if (e.getComponent().getName().equals("fieldPuesto"))
		{
			if (textFieldPuesto.getText().length() == 9) {
	            e.consume();
	        }
		}
	}
}
