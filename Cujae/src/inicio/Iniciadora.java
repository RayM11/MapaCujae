package inicio;

import interfaces.PantallaPresentacion;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.UIManager;

import logica.Universidad;
import auxiliar.Configuracion;
import auxiliar.Usuario;

public class Iniciadora {

	

	public static void establecerDirectorios(){


		File data = new File("data");

		data.mkdir();

		File admin = new File("data/admin.dat");

		if(!admin.exists()){
			Usuario u = new Usuario();
			u.crearAdmin("Virgilio66", "StormAproaching");
		}

	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); 
		} catch (Throwable e) {
			e.printStackTrace();
		} 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Universidad.getCujae();
					Iniciadora.establecerDirectorios();

					Configuracion configActual = new Configuracion();
					PantallaPresentacion frame = new PantallaPresentacion(configActual);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
