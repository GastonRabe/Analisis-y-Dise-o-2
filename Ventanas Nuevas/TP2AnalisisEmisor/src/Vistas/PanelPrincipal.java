package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PanelPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JLabel lblNewLabel_3;
	private JTextField textFieldPuesto;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private JButton btnNewButton_1;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JPanel panel_5;
	private JButton btnNewButton_2;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel_4;

	private ConectaServidor servidor;
	private JTextField textFieldIP;
	private JTextField textFieldPuerto;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		this.textFieldPuesto.setBounds(10, 82, 171, 20);
		this.panel_7.add(this.textFieldPuesto);
		this.textFieldPuesto.setColumns(10);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setBounds(10, 51, 171, 20);
		this.panel_7.add(this.textFieldIP);
		this.textFieldIP.setColumns(10);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setBounds(10, 21, 171, 20);
		this.panel_7.add(this.textFieldPuerto);
		this.textFieldPuerto.setColumns(10);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel);
		
		this.lblNewLabel = new JLabel("Asistencia M\u00E9dica");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setAlignmentX(0.5f);
		this.lblNewLabel.setBounds(22, 58, 150, 28);
		this.panel.add(this.lblNewLabel);
		
		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_1);
		
		this.btnNewButton = new JButton("Solicitar");
		this.btnNewButton.setForeground(Color.WHITE);
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton.setBackground(Color.BLACK);
		this.btnNewButton.setBounds(51, 42, 100, 50);
		this.panel_1.add(this.btnNewButton);
		
		this.panel_2 = new JPanel();
		this.panel_2.setLayout(null);
		this.panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_2);
		
		this.lblNewLabel_1 = new JLabel("Foco de Incendio");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(32, 59, 147, 14);
		this.panel_2.add(this.lblNewLabel_1);
		
		this.panel_3 = new JPanel();
		this.panel_3.setLayout(null);
		this.panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_3);
		
		this.btnNewButton_1 = new JButton("Solicitar");
		this.btnNewButton_1.setForeground(Color.WHITE);
		this.btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton_1.setBackground(Color.BLACK);
		this.btnNewButton_1.setBounds(50, 41, 100, 50);
		this.panel_3.add(this.btnNewButton_1);
		
		this.panel_4 = new JPanel();
		this.panel_4.setLayout(null);
		this.panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_4);
		
		this.lblNewLabel_2 = new JLabel("Personal de Seguridad");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_2.setBounds(10, 61, 192, 14);
		this.panel_4.add(this.lblNewLabel_2);
		
		this.panel_5 = new JPanel();
		this.panel_5.setLayout(null);
		this.panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_5);
		
		this.btnNewButton_2 = new JButton("Solicitar");
		this.btnNewButton_2.addActionListener(this);
		this.btnNewButton_2.setForeground(Color.WHITE);
		this.btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton_2.setBackground(Color.BLACK);
		this.btnNewButton_2.setBounds(50, 46, 100, 50);
		this.panel_5.add(this.btnNewButton_2);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		/*try {
            Socket socket = new Socket("localhost",1233);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(textFieldPuesto.getText());
            out.close();
            
            socket.close();
            //jTextArea1.setText("");
            
        } catch (Exception ee) {
            ee.printStackTrace();
        }*/
		this.servidor  = new ConectaServidor();
		this.servidor.start();
	}
}
