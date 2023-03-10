package co.edu.unbosque.model.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.PokemonDTO;

public class PokemonFile {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo;

	public PokemonFile() {
		this.archivo = new File("src/pokemones.dat");
		if (!this.archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void write(final ArrayList<PokemonDTO> lst) {
		try {
			(this.salida = new ObjectOutputStream(new FileOutputStream(this.archivo))).writeObject(lst);
			salida.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		}
	}

	public ArrayList<PokemonDTO> read() {
		ArrayList<PokemonDTO> salida = new ArrayList<PokemonDTO>();
		if (this.archivo.length() != 0L) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				salida = (ArrayList<PokemonDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (ClassNotFoundException e3) {
				e3.printStackTrace();
			}
		}
		return salida;
	}

	public ObjectInputStream getEntrada() {
		return this.entrada;
	}

	public void setEntrada(final ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return this.salida;
	}

	public void setSalida(final ObjectOutputStream salida) {
		this.salida = salida;
	}

	public File getArchivo() {
		return this.archivo;
	}

	public void setArchivo(final File archivo) {
		this.archivo = archivo;
	}
}
