package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class PanelAvisoRecepcion extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_tipo;
	private JLabel lblNewLabel_3;
	private JTextField textField_lugar;
	private JLabel lblNewLabel_4;
	private JTextField textField_hora;
	private JButton btnNewButton;
	private JTextField txtNoRecibida;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAvisoRecepcion frame = new PanelAvisoRecepcion();
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
	public PanelAvisoRecepcion(String tipo, String lugar) {
		setBackground(SystemColor.inactiveCaptionText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		this.contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.contentPane.add(this.panel);
		this.panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.lblNewLabel_1 = new JLabel("Alerta Enviada");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel.add(this.lblNewLabel_1);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(null);
		
		this.lblNewLabel_2 = new JLabel("Tipo:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_2.setBounds(10, 11, 50, 14);
		this.panel_2.add(this.lblNewLabel_2);
		
		this.textField_tipo = new JTextField();
		this.textField_tipo.setEditable(false);
		this.textField_tipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField_tipo.setBounds(54, 8, 119, 20);
		this.panel_2.add(this.textField_tipo);
		this.textField_tipo.setColumns(10);
		
		this.lblNewLabel_3 = new JLabel("Lugar:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_3.setBounds(253, 10, 50, 17);
		this.panel_2.add(this.lblNewLabel_3);
		
		this.textField_lugar = new JTextField();
		this.textField_lugar.setEditable(false);
		this.textField_lugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField_lugar.setBounds(306, 8, 106, 20);
		this.panel_2.add(this.textField_lugar);
		this.textField_lugar.setColumns(10);
		
		this.lblNewLabel_4 = new JLabel("Hora:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_4.setBounds(168, 39, 49, 14);
		this.panel_2.add(this.lblNewLabel_4);
		
		this.textField_hora = new JTextField();
		this.textField_hora.setEditable(false);
		this.textField_hora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField_hora.setBounds(213, 36, 58, 20);
		this.panel_2.add(this.textField_hora);
		this.textField_hora.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.btnNewButton = new JButton("OK");
		this.btnNewButton.setEnabled(false);
		this.btnNewButton.setBounds(181, 101, 85, 21);
		this.panel_1.add(this.btnNewButton);
		
		this.txtNoRecibida = new JTextField();
		this.txtNoRecibida.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.txtNoRecibida.setText("No Recibida");
		this.txtNoRecibida.setEditable(false);
		this.txtNoRecibida.setBounds(151, 31, 143, 59);
		this.panel_1.add(this.txtNoRecibida);
		this.txtNoRecibida.setColumns(10);
		
		this.textField_lugar.setText(lugar);
		this.textField_tipo.setText(tipo);
		this.textField_hora.setText(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		
		this.setVisible(true);
	}

	@Override
	public String getPuerto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPuesto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActionListener(ActionListener a) {
		this.btnNewButton.addActionListener(a);
	}

	@Override
	public void showMensaje(String mensaje) {
		this.txtNoRecibida.setText(mensaje);
		this.btnNewButton.setEnabled(true);
	}

	@Override
	public void visible(boolean visible) {
		this.setVisible(false);
		this.dispose();
		
	}
}
