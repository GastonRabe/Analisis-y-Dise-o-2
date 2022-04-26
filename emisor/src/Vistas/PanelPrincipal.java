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
	private JLabel lblNewLabel_3;
	private JTextField textFieldPuesto;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private JButton btn_solicitarIncendio;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JPanel panel_5;
	private JButton btn_solicitarSeguridad;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel_4;

	private ConectaServidor servidor;
	private JTextField textFieldPuerto;
	private JTextField textFieldIP;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btn_solicitarMedico;
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
		setBounds(100, 100, 450, 600);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(Color.BLACK);
		this.contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal);
		this.panelPrincipal.setLayout(new GridLayout(4, 2, 0, 0));
		
		this.panel_6 = new JPanel();
		this.panelPrincipal.add(this.panel_6);
		this.panel_6.setLayout(null);
		
		this.lblNewLabel_3 = new JLabel("Puesto de trabajo:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_3.setBounds(31, 74, 195, 37);
		this.panel_6.add(this.lblNewLabel_3);
		
		this.lblNewLabel_4 = new JLabel("(Campos obligatorios)");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel_4.setBounds(31, 108, 195, 31);
		this.panel_6.add(this.lblNewLabel_4);
		
		this.lblNewLabel_5 = new JLabel("IP:");
		this.lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_5.setBounds(31, 24, 46, 14);
		this.panel_6.add(this.lblNewLabel_5);
		
		this.lblNewLabel_6 = new JLabel("Puerto:");
		this.lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_6.setBounds(31, 48, 118, 25);
		this.panel_6.add(this.lblNewLabel_6);
		
		this.panel_7 = new JPanel();
		this.panelPrincipal.add(this.panel_7);
		this.panel_7.setLayout(null);
		
		this.textFieldPuesto = new JTextField();
		this.textFieldPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPuesto.setBounds(20, 82, 171, 20);
		this.panel_7.add(this.textFieldPuesto);
		this.textFieldPuesto.setColumns(10);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setHorizontalAlignment(SwingConstants.CENTER);
		this.textFieldPuerto.addKeyListener(this);
		this.textFieldPuerto.setBounds(20, 51, 171, 20);
		this.panel_7.add(this.textFieldPuerto);
		this.textFieldPuerto.setColumns(10);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.textFieldIP.setBounds(20, 20, 171, 20);
		this.panel_7.add(this.textFieldIP);
		this.textFieldIP.setColumns(10);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel);
		
		this.lblNewLabel = new JLabel("Asistencia M\u00E9dica");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setAlignmentX(0.5f);
		this.lblNewLabel.setBounds(31, 55, 150, 28);
		this.panel.add(this.lblNewLabel);
		
		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_1);
		
		btn_solicitarMedico = new JButton("Solicitar");
		this.btn_solicitarMedico.setActionCommand("Medico");
		btn_solicitarMedico.setForeground(Color.BLACK);
		btn_solicitarMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_solicitarMedico.setBackground(SystemColor.inactiveCaption);
		btn_solicitarMedico.setBounds(51, 42, 100, 50);
		this.panel_1.add(btn_solicitarMedico);
		
		this.panel_2 = new JPanel();
		this.panel_2.setLayout(null);
		this.panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_2);
		
		this.lblNewLabel_2 = new JLabel("Personal de Seguridad");
		this.lblNewLabel_2.setBounds(20, 60, 192, 14);
		this.panel_2.add(this.lblNewLabel_2);
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		this.panel_3 = new JPanel();
		this.panel_3.setLayout(null);
		this.panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_3);
		
		this.btn_solicitarSeguridad = new JButton("Solicitar");
		this.btn_solicitarSeguridad.setBounds(51, 42, 100, 50);
		this.panel_3.add(this.btn_solicitarSeguridad);
		this.btn_solicitarSeguridad.setActionCommand("Seguridad");
		
		this.btn_solicitarSeguridad.setForeground(Color.BLACK);
		this.btn_solicitarSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btn_solicitarSeguridad.setBackground(SystemColor.inactiveCaption);
		
		this.panel_4 = new JPanel();
		this.panel_4.setLayout(null);
		this.panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_4);
		
		this.lblNewLabel_1 = new JLabel("Foco de Incendio");
		this.lblNewLabel_1.setBounds(34, 60, 147, 14);
		this.panel_4.add(this.lblNewLabel_1);
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		this.panel_5 = new JPanel();
		this.panel_5.setLayout(null);
		this.panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_5);
		
		this.btn_solicitarIncendio = new JButton("Solicitar");
		this.btn_solicitarIncendio.setBounds(51, 42, 100, 50);
		this.panel_5.add(this.btn_solicitarIncendio);
		this.btn_solicitarIncendio.setActionCommand("Foco Incendio");
		this.btn_solicitarIncendio.setForeground(Color.BLACK);
		this.btn_solicitarIncendio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btn_solicitarIncendio.setBackground(SystemColor.inactiveCaption);
		
		setVisible(true);
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
