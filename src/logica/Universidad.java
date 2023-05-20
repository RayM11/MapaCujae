package logica;

import java.io.File;
import java.util.ArrayList;

import cu.edu.cujae.ceis.graph.LinkedGraph;

public class Universidad {
	
	private static Universidad cujae = null;
	private File datFile;
	private LinkedGraph mapa;
	private Visitante visitante;
	private String rector;
	
	private Universidad(){
		datFile = new File("grafo.dat");
	}
	
	public static Universidad getCujae(){
		
		if(cujae == null)
			cujae = new Universidad();
		return cujae;
	}
	
	public ArrayList<LugarDeInteres> busquedaLugares(ArrayList<LugarDeInteres> lugaresDI, String fragmento){
		
		ArrayList<LugarDeInteres> lugaresEncontrados = new ArrayList<LugarDeInteres>();
		
		for (LugarDeInteres lugarActual : lugaresDI)
			if (lugarActual.getNombre().contains(fragmento))
				lugaresEncontrados.add(lugarActual);
		
		return lugaresEncontrados;
	}
}
