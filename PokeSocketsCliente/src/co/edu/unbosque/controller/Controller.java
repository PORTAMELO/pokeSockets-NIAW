package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.CrearCuenta;
import co.edu.unbosque.view.IngresoAlmacen;
import co.edu.unbosque.view.MenuInterno;
import co.edu.unbosque.view.MenuPrincipal;

public class Controller implements ActionListener {
	public MenuPrincipal menup;
	public IngresoAlmacen ingresoa;
	public CrearCuenta crearc;
	public MenuInterno menui;

	public Controller() {
		menup = new MenuPrincipal();
		ingresoa = new IngresoAlmacen();
		crearc = new CrearCuenta();
		menui = new MenuInterno();
		asignarOyentes();
	}

	public void asignarOyentes() {
		menup.getCrear().addActionListener(this);
		menup.getIngresar().addActionListener(this);
		crearc.getCrear().addActionListener(this);
		crearc.getIngresar().addActionListener(this);
		ingresoa.getCrear().addActionListener(this);
		ingresoa.getIngresar().addActionListener(this);
		menui.getActualizar().addActionListener(this);
		menui.getAgregar().addActionListener(this);
		menui.getBolsa().addActionListener(this);
		menui.getEliminar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accionado = e.getActionCommand().replace(" ", "");
		if (accionado.equalsIgnoreCase("crearU")) {
			menup.setVisible(false);
			ingresoa.setVisible(false);
			ingresoa.resetear();
			crearc.setVisible(true);

		} else if (accionado.equalsIgnoreCase("ingresarU")) {
			menup.setVisible(false);
			crearc.setVisible(false);
			ingresoa.setVisible(true);
		} else if (accionado.equalsIgnoreCase("ingresarAl")) {
			String usuario = ingresoa.getUsuario().getText();
			String password = ingresoa.getPassword().getText();
			if (1 == 1) {// aca va a ir lo de comprobar si ya existe el ususario
				ingresoa.setVisible(false);
				ingresoa.resetear();
				menui.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido ingresar correctamente");
			}

		} else if (accionado.equalsIgnoreCase("agregarU")) {
			String usuario = crearc.getUsuario().getText();
			String password = crearc.getPassword().getText();
			if (1 == 1) {// aca va a ir lo de comprobar si ya existe el ususario
				crearc.setVisible(false);
				crearc.resetear();
				menui.setVisible(true);
			}
		} else if (accionado.equalsIgnoreCase("agregarMI")) {
			menui.setVisible(false);

		} else if (accionado.equalsIgnoreCase("actualizarMI")) {
			menui.setVisible(false);

		} else if (accionado.equalsIgnoreCase("eliminarMI")) {
			menui.setVisible(false);

		} else if (accionado.equalsIgnoreCase("bolsaMI")) {
			menui.setVisible(false);

		}

	}

}
