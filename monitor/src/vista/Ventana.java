package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame implements IVista{

	private JPanel contentPane;
	private JTextField textField_puerto;
	private JTextField textField_ip;
	private JButton btnNewButton;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Monitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new TitledBorder(null, "Puerto:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.setBounds(175, 3, 129, 40);
		this.contentPane.add(this.panel_2);
		this.panel_2.setLayout(new BorderLayout(0, 0));
		
		this.panel_1 = new JPanel();
		this.panel_2.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.textField_puerto = new JTextField();
		this.textField_puerto.setBounds(0, 0, 117, 19);
		this.panel_1.add(this.textField_puerto);
		this.textField_puerto.setColumns(10);
		
		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(null, "Ip:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.setBounds(10, 3, 129, 40);
		this.contentPane.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.textField_ip = new JTextField();
		this.textField_ip.setEditable(false);
		this.panel.add(this.textField_ip);
		this.textField_ip.setColumns(10);
		
		this.btnNewButton = new JButton("Escuchar");
		this.btnNewButton.setBounds(330, 12, 85, 21);
		this.contentPane.add(this.btnNewButton);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 43, 416, 110);
		this.contentPane.add(this.scrollPane);
		
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.scrollPane.setViewportView(this.textArea);
		
		try {
            this.textField_ip.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener a) {
		this.btnNewButton.addActionListener(a);
		
	}

	@Override
	public String getPuerto() {
		// TODO Auto-generated method stub
		return this.textField_puerto.getText();
	}

	@Override
	public void nuevoMensaje(String mensaje) {
		// TODO Auto-generated method stub
		this.textArea.append(mensaje + "\n");
	}

	@Override
	public void setStatusButton(boolean status) {
		this.textField_puerto.setEditable(status);
		this.btnNewButton.setEnabled(status);
		
	}
}
