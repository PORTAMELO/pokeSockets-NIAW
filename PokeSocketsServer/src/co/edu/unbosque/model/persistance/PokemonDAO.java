package co.edu.unbosque.model.persistance;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.PokemonDTO;

public class PokemonDAO {
	private PokemonFile archivo;
	private ArrayList<PokemonDTO> list;

	public PokemonDAO(PokemonFile archivo) {
		this.archivo = archivo;
		list = new ArrayList<PokemonDTO>();
	}

	public PokemonDTO buscarUsuario(String usuario, ArrayList<PokemonDTO> pokemones) {
		PokemonDTO buscarpokemon = null;
		if (list.size() != 0) {
			for (int i = 0; i < pokemones.size(); i++) {
				if (usuario.equals(pokemones.get(i).getUsuario())) {
					buscarpokemon = pokemones.get(i);
					return buscarpokemon;
				}
			}
		}
		return buscarpokemon;
	}

	public PokemonDTO buscarPokemon(String usuario, String nombre, ArrayList<PokemonDTO> pokemones) {
		PokemonDTO buscarpokemon = null;
		if (list.size() != 0) {
			for (int i = 0; i < pokemones.size(); i++) {
				if (usuario.equals(pokemones.get(i).getUsuario())) {
					if (!usuario.equals(pokemones.get(i).getNombre())) {
						buscarpokemon = pokemones.get(i);
						return buscarpokemon;
					}
				}

			}
		}
		return buscarpokemon;
	}

	public boolean agregarPokemon(String usuario, String password, String nombre, String tipo, double peso,
			double altura, double velocidad, int edad, int ataque, int defensa) {

		PokemonDTO poke = new PokemonDTO(usuario, password, nombre, tipo, peso, altura, velocidad, edad, ataque,
				defensa);

		if (buscarPokemon(usuario, nombre, list) != null) {
			list.add(poke);
			archivo.write(list);
			JOptionPane.showMessageDialog(null, "Agregado correctamente");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El pokemon no ha sido agregado.");
			return false;
		}
	}

	public void eliminarPokemon(String usuario, String nombre) {

		if (buscarPokemon(usuario, nombre, list) != null) {
			try {
				PokemonDTO borrar = buscarPokemon(usuario, nombre, list);
				list.remove(borrar);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.write(list);
				JOptionPane.showMessageDialog(null, "El pokemon se elimino correctamente");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "El candidato ingresado no se encuentra registrado");
		}

	}

	public void actualizarPokemon(String usuario, String password, String nombre, String tipo, double peso,
			double altura, double velocidad, int edad, int ataque, int defensa) {
		if (buscarPokemon(usuario, password, list) != null) {
			try {
				PokemonDTO actualizar = buscarPokemon(usuario, password, list);
				actualizar.setTipo(tipo);
				actualizar.setPeso(peso);
				actualizar.setAltura(altura);
				actualizar.setVelocidad(velocidad);
				actualizar.setEdad(edad);
				actualizar.setAtaque(ataque);
				actualizar.setDefensa(defensa);
				JOptionPane.showMessageDialog(null, "Actualizado correctamente");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<PokemonDTO> getList() {
		return list;
	}

	public void setList(ArrayList<PokemonDTO> list) {
		this.list = list;
	}

}
