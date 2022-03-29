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

public class PanelAvisoRecepcion extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

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
		this.contentPane.setLayout(null);
		
		this.lblNewLabel = new JLabel("\u00A1 Se ha recibido la alerta !");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		this.lblNewLabel.setBounds(20, 106, 391, 55);
		this.contentPane.add(this.lblNewLabel);
	}

}
