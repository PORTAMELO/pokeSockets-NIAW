package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame {
	public JButton crear, ingresar;
	public JLabel label;
	public ImageIcon imagen, icono;

	public MenuPrincipal() {
		setSize(437, 678);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void inicializarComponentes() {
		label = new JLabel();
		add(label);
		imagen = new ImageIcon(getClass().getResource("/co/edu/unbosque/util/menuprincipal.jpeg"));
		icono = new ImageIcon(imagen.getImage().getScaledInstance(421, 640, Image.SCALE_AREA_AVERAGING));

		label.setIcon(icono);
		label.setBounds(0, 0, 421, 640);

		crear = new JButton();
		crear.setActionCommand("crearU");
		crear.setBounds(127, 420, 252, 41);
		crear.setFocusPainted(false);
		crear.setBorderPainted(false);
		crear.setContentAreaFilled(false);
		label.add(crear);

		ingresar = new JButton();
		ingresar.setActionCommand("ingresarU");
		ingresar.setBounds(127, 344, 252, 41);
		ingresar.setFocusPainted(false);
		ingresar.setBorderPainted(false);
		ingresar.setContentAreaFilled(false);
		label.add(ingresar);

	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getIngresar() {
		return ingresar;
	}

}
