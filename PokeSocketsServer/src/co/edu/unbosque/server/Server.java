package co.edu.unbosque.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.persistance.PokemonDAO;
import co.edu.unbosque.model.persistance.PokemonFile;

public class Server extends Thread {

	private ServerSocket servidor;
	private Socket client, respond;
	private ObjectOutputStream enviar;
	private ObjectInputStream recibir;
	private int port;
	private PokemonDAO candao;
	private PokemonFile archivo;
	private String ip;

	public Server(final int portt) {
		try {
			servidor = null;
			client = null;
			respond = null;
			enviar = null;
			recibir = null;
			port = portt;
			archivo = new PokemonFile();
			candao = new PokemonDAO(archivo);
			ip = "localhost";
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				servidor = new ServerSocket(port);
				System.out.println("Server created, waiting for client");
				client = servidor.accept();
				System.out.println("Client Accepted");
				recibir = new ObjectInputStream(client.getInputStream());
				String txt = (String) recibir.readObject();
				System.out.println(txt);
				if (txt.contains("ADD")) {
					String[] tosplit = txt.split(" ");
					candao.agregarPokemon(tosplit[0], tosplit[1], tosplit[2], tosplit[3],
							Double.parseDouble(tosplit[4]), Double.parseDouble(tosplit[5]),
							Double.parseDouble(tosplit[6]), Integer.parseInt(tosplit[7]), Integer.parseInt(tosplit[8]),
							Integer.parseInt(tosplit[9]));
					archivo.write(candao.getList());
				} else if (txt.contains("UPD")) {
					String[] tosplit = txt.split(" ");
					candao.actualizarPokemon(tosplit[0], tosplit[1], tosplit[2], tosplit[3],
							Double.parseDouble(tosplit[4]), Double.parseDouble(tosplit[5]),
							Double.parseDouble(tosplit[6]), Integer.parseInt(tosplit[7]), Integer.parseInt(tosplit[8]),
							Integer.parseInt(tosplit[9]));
					archivo.write(candao.getList());
				} else if (txt.contains("DEL")) {
					String[] tosplit = txt.split(" ");
					candao.eliminarPokemon(tosplit[0], tosplit[2]);
					archivo.write(candao.getList());
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
