package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import auxiliar.Direccion;

public class Coordenadas {

	private float x;
	private float y;

	public Coordenadas(float x, float y){
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}

	/**
	 *	Recibe una coordenada destino y devuelve una lista de direcciones ordenada según el mayor movimiento 
	 * 	en cada dirección. Es para tener un orden de prioridad al elegir en qué dirección colocar el movimiento
	 * 	a la coordenada objetivo
	 */
	public ArrayList<Direccion> direccionHacia(Coordenadas cor2){
		
		// Direccion dir;
		
		float movY = cor2.getY() - y;
		float movX = cor2.getX() - x; 
		
		float movNorte = movY;
		float movSur = -1*movY;
		float movEste = movX;
		float movOeste = -1*movX;
		
		final Map<Direccion, Double> desplazamientos = new HashMap<>();
	    desplazamientos.put(Direccion.N, (double)movNorte);
	    desplazamientos.put(Direccion.S, (double)movSur);
	    desplazamientos.put(Direccion.E, (double)movEste);
	    desplazamientos.put(Direccion.O, (double)movOeste);
		
	    ArrayList<Direccion> direcciones = new ArrayList<>(desplazamientos.keySet());
	    Collections.sort(direcciones, new Comparator<Direccion>(){

			@Override
			public int compare(Direccion d1, Direccion d2) {
				
				return Double.compare(desplazamientos.get(d1), desplazamientos.get(d2));
			}
	    });
	    
	/*	if (abs(movY) > abs(movX))
		
			if (movY > 0)
				dir = Direccion.N;
			else
				dir = Direccion.S;
			
		else if (abs(movY) < abs(movX))
			if (movX > 0)
				dir = Direccion.E;
			else
				dir = Direccion.O;
		else
			throw new IllegalArgumentException("Movimiento diagonal intentado, situación no contemplada todavía");
		*/		
		return direcciones;
	}
	
}
