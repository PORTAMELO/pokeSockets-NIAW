package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuInterno extends JFrame {
	public JButton agregar, eliminar, actualizar, bolsa;
	public JLabel label;
	public ImageIcon imagen, icono;

	public MenuInterno() {
		setSize(437, 678);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public void inicializarComponentes() {
		label = new JLabel();
		add(label);
		imagen = new ImageIcon(getClass().getResource("/co/edu/unbosque/util/menuinterno.jpg"));
		icono = new ImageIcon(imagen.getImage().getScaledInstance(421, 640, Image.SCALE_AREA_AVERAGING));

		label.setIcon(icono);
		label.setBounds(0, 0, 421, 640);

		agregar = new JButton();
		agregar.setActionCommand("agregarMI");
		agregar.setBounds(95, 225, 229, 41);
		agregar.setFocusPainted(false);
		agregar.setBorderPainted(false);
		agregar.setContentAreaFilled(false);
		label.add(agregar);

		actualizar = new JButton();
		actualizar.setActionCommand("actualizarMI");
		actualizar.setBounds(98, 344, 227, 41);
		actualizar.setFocusPainted(false);
		actualizar.setBorderPainted(false);
		actualizar.setContentAreaFilled(false);
		label.add(actualizar);

		eliminar = new JButton();
		eliminar.setActionCommand("eliminarMI");
		eliminar.setBounds(95, 288, 229, 41);
		eliminar.setFocusPainted(false);
		eliminar.setBorderPainted(false);
		eliminar.setContentAreaFilled(false);
		label.add(eliminar);

		bolsa = new JButton();
		bolsa.setActionCommand("bolsaMI");
		bolsa.setBounds(147, 457, 150, 41);
		bolsa.setFocusPainted(false);
		bolsa.setBorderPainted(false);
		bolsa.setContentAreaFilled(false);
		label.add(bolsa);

	}

	public JButton getAgregar() {
		return agregar;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public JButton getBolsa() {
		return bolsa;
	}
}
