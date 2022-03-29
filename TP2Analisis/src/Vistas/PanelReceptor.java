package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PanelReceptor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTipoDeSolicitud;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.lblTipoDeSolicitud = new JLabel("Tipo de Solicitud");
		this.lblTipoDeSolicitud.setBounds(40, 50, 148, 25);
		this.lblTipoDeSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_1.add(this.lblTipoDeSolicitud);
		
		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_3);
		this.panel_3.setLayout(null);
		
		this.textField = new JTextField();
		this.textField.setBounds(10, 50, 192, 20);
		this.textField.setBackground(Color.WHITE);
		this.textField.setEditable(false);
		this.panel_3.add(this.textField);
		this.textField.setColumns(10);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_4);
		this.panel_4.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("Hora");
		this.lblNewLabel_1.setBounds(84, 50, 43, 25);
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_4.add(this.lblNewLabel_1);
		
		this.panel_6 = new JPanel();
		this.panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_6);
		this.panel_6.setLayout(null);
		
		this.textField_2 = new JTextField();
		this.textField_2.setBackground(Color.WHITE);
		this.textField_2.setEditable(false);
		this.textField_2.setBounds(10, 50, 192, 20);
		this.panel_6.add(this.textField_2);
		this.textField_2.setColumns(10);
		
		this.panel_7 = new JPanel();
		this.panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_7);
		this.panel_7.setLayout(null);
		
		this.lblNewLabel_2 = new JLabel("Lugar");
		this.lblNewLabel_2.setBounds(81, 50, 50, 25);
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel_7.add(this.lblNewLabel_2);
		
		this.panel_9 = new JPanel();
		this.panel_9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel_9);
		this.panel_9.setLayout(null);
		
		this.textField_1 = new JTextField();
		this.textField_1.setBackground(Color.WHITE);
		this.textField_1.setEditable(false);
		this.textField_1.setBounds(10, 50, 192, 20);
		this.panel_9.add(this.textField_1);
		this.textField_1.setColumns(10);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		
		this.panel_8 = new JPanel();
		this.contentPane.add(this.panel_8);
		this.panel_8.setLayout(null);
		
		this.btnNewButton = new JButton("Informar");
		this.btnNewButton.setToolTipText("");
		this.btnNewButton.setForeground(Color.WHITE);
		this.btnNewButton.setBackground(Color.BLACK);
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.btnNewButton.addActionListener(this);
		this.btnNewButton.setBounds(31, 22, 148, 91);
		this.panel_8.add(this.btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
