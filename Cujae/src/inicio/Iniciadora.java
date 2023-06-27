package inicio;

import interfaces.PantallaPresentación;

import java.awt.EventQueue;
import javax.swing.UIManager;

import auxiliar.Configuracion;
import auxiliar.Usuario;

public class Iniciadora {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); 
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Usuario u = new Usuario();
					u.crearAdmin("sexo", "sexo");
					Configuracion configActual = new Configuracion();
					PantallaPresentación frame = new PantallaPresentación(configActual);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
