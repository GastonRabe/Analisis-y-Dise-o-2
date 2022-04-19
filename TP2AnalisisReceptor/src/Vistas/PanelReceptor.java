package Vistas;

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

public class PanelReceptor extends JFrame implements ActionListener {

	private static PanelReceptor instance;
	private JPanel contentPane;
	private JPanel panel_2;
	private JPanel panel_5;
	private JPanel panel;
	private JLabel lblTipoDeSolicitud;
	private JPanel panel_1;
	private JTextField textField;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JTextField textField_1;
	private JPanel panel_6;
	private JLabel lblNewLabel_1;
	private JPanel panel_7;
	private JTextField textFieldLugar;
	private JPanel panel_8;
	private JPanel panel_9;
	private JButton btnNewButton;
	private JRadioButton rdbtnAsistenciaMedica;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelReceptor frame = new PanelReceptor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// ConectaServidor server= new ConectaServidor();
		// server.start();

		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(1233);

					while (true) {

						Socket soc = s.accept();
						PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

						String msg = in.readLine();

						PanelReceptor.getInstance().getFieldLugar().setText(msg);
						System.out.println(msg);
						//PanelReceptor.getInstance().textFieldLugar.setText("toti");
					}

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}.start();

	}

	public static PanelReceptor getInstance() {
		if (instance == null) {
			instance = new PanelReceptor();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public PanelReceptor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(5, 2, 0, 0));

		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		this.panel_2.setLayout(null);

		this.lblNewLabel_2 = new JLabel("Solicitudes permitidas:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_2.setBounds(10, 22, 192, 64);
		this.panel_2.add(this.lblNewLabel_2);

		this.panel_5 = new JPanel();
		this.contentPane.add(this.panel_5);
		this.panel_5.setLayout(null);

		this.rdbtnAsistenciaMedica = new JRadioButton("Asistencia Medica");
		this.rdbtnAsistenciaMedica.setBounds(40, 16, 150, 23);
		this.panel_5.add(this.rdbtnAsistenciaMedica);

		this.rdbtnNewRadioButton_1 = new JRadioButton("Personal de seguridad");
		this.rdbtnNewRadioButton_1.setBounds(40, 42, 166, 23);
		this.panel_5.add(this.rdbtnNewRadioButton_1);

		this.rdbtnNewRadioButton_2 = new JRadioButton("Foco de incendio");
		this.rdbtnNewRadioButton_2.setBounds(40, 68, 150, 23);
		this.panel_5.add(this.rdbtnNewRadioButton_2);

		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel);

		this.lblTipoDeSolicitud = new JLabel("Tipo de Solicitud");
		this.lblTipoDeSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblTipoDeSolicitud.setBounds(40, 50, 148, 25);
		this.panel.add(this.lblTipoDeSolicitud);

		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_1);

		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		this.textField.setBackground(Color.WHITE);
		this.textField.setBounds(10, 50, 192, 20);
		this.panel_1.add(this.textField);

		this.panel_3 = new JPanel();
		this.panel_3.setLayout(null);
		this.panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_3);

		this.lblNewLabel = new JLabel("Hora");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblNewLabel.setBounds(84, 50, 43, 25);
		this.panel_3.add(this.lblNewLabel);

		this.panel_4 = new JPanel();
		this.panel_4.setLayout(null);
		this.panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_4);

		this.textField_1 = new JTextField();
		this.textField_1.setEditable(false);
		this.textField_1.setColumns(10);
		this.textField_1.setBackground(Color.WHITE);
		this.textField_1.setBounds(10, 50, 192, 20);
		this.panel_4.add(this.textField_1);

		this.panel_6 = new JPanel();
		this.panel_6.setLayout(null);
		this.panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_6);

		this.lblNewLabel_1 = new JLabel("Lugar");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblNewLabel_1.setBounds(81, 50, 50, 25);
		this.panel_6.add(this.lblNewLabel_1);

		this.panel_7 = new JPanel();
		this.panel_7.setLayout(null);
		this.panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_7);

		this.textFieldLugar = new JTextField();
		this.textFieldLugar.setEditable(false);
		this.textFieldLugar.setForeground(Color.BLACK);
		this.textFieldLugar.setColumns(10);
		this.textFieldLugar.setBackground(Color.WHITE);
		this.textFieldLugar.setBounds(10, 50, 192, 20);
		this.panel_7.add(this.textFieldLugar);

		this.panel_8 = new JPanel();
		this.contentPane.add(this.panel_8);

		this.panel_9 = new JPanel();
		this.panel_9.setLayout(null);
		this.contentPane.add(this.panel_9);

		this.btnNewButton = new JButton("Confirmar Recepcion");
		this.btnNewButton.setToolTipText("");
		this.btnNewButton.setForeground(Color.WHITE);
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.btnNewButton.setBackground(Color.BLACK);
		this.btnNewButton.setBounds(10, 34, 192, 44);
		this.panel_9.add(this.btnNewButton);

		
	}

	public JTextField getFieldLugar() {
		return this.textFieldLugar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}