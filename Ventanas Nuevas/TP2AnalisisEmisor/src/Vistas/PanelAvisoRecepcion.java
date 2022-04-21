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
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

public class PanelAvisoRecepcion extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public PanelAvisoRecepcion() {
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
		
		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField.setBounds(54, 8, 86, 20);
		this.panel_2.add(this.textField);
		this.textField.setColumns(10);
		
		this.lblNewLabel_3 = new JLabel("Lugar:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_3.setBounds(276, 10, 50, 17);
		this.panel_2.add(this.lblNewLabel_3);
		
		this.textField_1 = new JTextField();
		this.textField_1.setEditable(false);
		this.textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField_1.setBounds(326, 8, 86, 20);
		this.panel_2.add(this.textField_1);
		this.textField_1.setColumns(10);
		
		this.lblNewLabel_4 = new JLabel("Hora:");
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblNewLabel_4.setBounds(143, 39, 49, 14);
		this.panel_2.add(this.lblNewLabel_4);
		
		this.textField_2 = new JTextField();
		this.textField_2.setEditable(false);
		this.textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.textField_2.setBounds(187, 36, 86, 20);
		this.panel_2.add(this.textField_2);
		this.textField_2.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.lblNewLabel = new JLabel("No Recibida");
		this.lblNewLabel.setBackground(Color.GRAY);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		this.lblNewLabel.setBounds(112, 22, 198, 78);
		this.panel_1.add(this.lblNewLabel);
	}

}
