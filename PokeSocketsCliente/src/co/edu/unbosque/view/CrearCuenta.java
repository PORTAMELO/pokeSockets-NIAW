package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CrearCuenta extends JFrame {
	public JTextField usuario, password;
	public JLabel label;
	public ImageIcon imagen, icono;
	public JButton crear, ingresar;

	public CrearCuenta() {
		setSize(437, 678);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);

	}

	public void inicializarComponentes() {
		label = new JLabel();
		add(label);
		imagen = new ImageIcon(getClass().getResource("/co/edu/unbosque/util/crearcuenta.jpeg"));
		icono = new ImageIcon(imagen.getImage().getScaledInstance(421, 640, Image.SCALE_AREA_AVERAGING));

		label.setIcon(icono);
		label.setBounds(0, 0, 421, 640);

		usuario = new JTextField();
		usuario.setOpaque(false);
		usuario.setBounds(100, 197, 235, 35);
		label.add(usuario);

		password = new JTextField();
		password.setOpaque(false);
		password.setBounds(100, 277, 235, 35);
		label.add(password);

		crear = new JButton();
		crear.setActionCommand("agregarU");
		crear.setBounds(135, 502, 152, 50);
		crear.setFocusPainted(false);
		crear.setBorderPainted(false);
		crear.setContentAreaFilled(false);
		label.add(crear);

		ingresar = new JButton();
		ingresar.setActionCommand("ingresarU");
		ingresar.setBounds(255, 565, 85, 20);
		ingresar.setFocusPainted(false);
		ingresar.setBorderPainted(false);
		ingresar.setContentAreaFilled(false);
		label.add(ingresar);

	}

	public void resetear() {
		usuario.setText("");
		password.setText("");
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getIngresar() {
		return ingresar;
	}

}
