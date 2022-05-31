package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ventanaServidor extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textField_ip;
	private JTextField textField_puerto;
	private JButton btn_escuchar;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JTextField textField_ipMonitor;
	private JTextField textField_puertoMonitor;
	private JTextField txt_status;



	/**
	 * Create the frame.
	 */
	public ventanaServidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 300);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.NORTH);
		this.panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new TitledBorder(null, "IP:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		this.panel.add(this.panel_3);
		
		this.textField_ip = new JTextField();
		this.textField_ip.setEditable(false);
		this.panel_3.add(this.textField_ip);
		this.textField_ip.setColumns(10);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(null, "Puerto:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		this.panel.add(this.panel_4);
		
		this.textField_puerto = new JTextField();
		this.textField_puerto.addKeyListener(this);
		this.panel_4.add(this.textField_puerto);
		this.textField_puerto.setColumns(10);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(null);
		
		this.btn_escuchar = new JButton("Escuchar");
		this.btn_escuchar.setBounds(50, 15, 100, 21);
		this.panel_2.add(this.btn_escuchar);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new TitledBorder(null, "Eventos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		this.contentPane.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_1.add(this.scrollPane, BorderLayout.CENTER);
		
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.scrollPane.setViewportView(this.textArea);
		try {
			this.textField_ip.setText(InetAddress.getLocalHost().getHostAddress());
			
			this.panel_5 = new JPanel();
			this.panel_5.setBorder(new TitledBorder(null, "Ip Monitor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			this.panel.add(this.panel_5);
			
			this.textField_ipMonitor = new JTextField();
			this.panel_5.add(this.textField_ipMonitor);
			this.textField_ipMonitor.setColumns(10);
			
			this.panel_6 = new JPanel();
			this.panel_6.setBorder(new TitledBorder(null, "Puerto Monitor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			this.panel.add(this.panel_6);
			
			this.textField_puertoMonitor = new JTextField();
			this.panel_6.add(this.textField_puertoMonitor);
			this.textField_puertoMonitor.setColumns(10);
			
			this.txt_status = new JTextField();
			this.txt_status.setFont(new Font("Tahoma", Font.PLAIN, 14));
			this.txt_status.setHorizontalAlignment(SwingConstants.CENTER);
			this.txt_status.setEditable(false);
			this.panel.add(this.txt_status);
			this.txt_status.setColumns(10);
			
			this.panel_7 = new JPanel();
			this.contentPane.add(this.panel_7, BorderLayout.SOUTH);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setAlwaysOnTop(true);
		setVisible(true);
	}



	@Override
	public void setActionListener(ActionListener a) {
		this.btn_escuchar.addActionListener(a);
		
	}



	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return this.textField_ip.getText();
	}



	@Override
	public int getPuerto() {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.textField_puerto.getText());
	}
	
	public void nuevoMensaje(String mensaje) {
		this.textArea.append(mensaje + "\n");
	}

	public void setEnableButton(boolean b) {
		this.btn_escuchar.setEnabled(b);
		this.textField_puerto.setEditable(false);
		this.textField_ipMonitor.setEditable(b);
		this.textField_puertoMonitor.setEditable(b);
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

        if (textField_puerto.getText().trim().length() == 4) {
            e.consume();
        }
	}



	@Override
	public String getIpMonitor() {
		// TODO Auto-generated method stub
		return this.textField_ipMonitor.getText();
	}



	@Override
	public int getPuertoMonitor() {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.textField_puertoMonitor.getText());
	}



	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		this.txt_status.setText(status);
	}



	@Override
	public void setPuerto(String puerto) {
		// TODO Auto-generated method stub
		this.textField_puerto.setText(puerto);
	}
}
