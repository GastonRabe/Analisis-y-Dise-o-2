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
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNewButton;

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
		setTitle("Sistema de alarma");
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
		this.panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_3);
		this.panel_3.setLayout(null);
		
		this.lblNewLabel = new JLabel("Asistencia M\u00E9dica");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setBounds(22, 84, 150, 28);
		this.lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_3.add(this.lblNewLabel);
		
		this.panel = new JPanel();
		this.panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel);
		this.panel.setLayout(null);
		
		this.btnNewButton = new JButton("Solicitar");
		this.btnNewButton.addActionListener(this);
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton.setBackground(Color.BLACK);
		this.btnNewButton.setForeground(Color.WHITE);
		this.btnNewButton.setBounds(50, 65, 100, 50);
		this.panel.add(this.btnNewButton);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_4);
		this.panel_4.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("Foco de Incendio");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_1.setBounds(31, 72, 147, 14);
		this.panel_4.add(this.lblNewLabel_1);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.btnNewButton_1 = new JButton("Solicitar");
		this.btnNewButton_1.setForeground(Color.WHITE);
		this.btnNewButton_1.setBackground(Color.BLACK);
		this.btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton_1.setBounds(50, 65, 100, 50);
		this.panel_1.add(this.btnNewButton_1);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_5);
		this.panel_5.setLayout(null);
		
		this.lblNewLabel_2 = new JLabel("Personal de Seguridad");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_2.setBounds(10, 78, 192, 14);
		this.panel_5.add(this.lblNewLabel_2);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panelPrincipal.add(this.panel_2);
		this.panel_2.setLayout(null);
		
		this.btnNewButton_2 = new JButton("Solicitar");
		this.btnNewButton_2.setForeground(Color.WHITE);
		this.btnNewButton_2.setBackground(Color.BLACK);
		this.btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnNewButton_2.setBounds(50, 65, 100, 50);
		this.panel_2.add(this.btnNewButton_2);
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
