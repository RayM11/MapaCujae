package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import auxiliar.Direccion;

public class Coordenadas {

	private double x;
	private double y;

	public Coordenadas(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

	/**
	 *	Recibe una coordenada destino y devuelve una lista de direcciones ordenada según el mayor movimiento 
	 * 	en cada dirección. Es para tener un orden de prioridad al elegir en qué dirección colocar el movimiento
	 * 	a la coordenada objetivo
	 */
	public ArrayList<Direccion> direccionHacia(Coordenadas cor2){
		
		// Direccion dir;
		
		double movY = cor2.getY() - y;
		double movX = cor2.getX() - x; 
		
		double movNorte = movY;
		double movSur = -1*movY;
		double movEste = movX;
		double movOeste = -1*movX;
		
		final Map<Direccion, Double> desplazamientos = new HashMap<>();
	    desplazamientos.put(Direccion.N, movNorte);
	    desplazamientos.put(Direccion.S, movSur);
	    desplazamientos.put(Direccion.E, movEste);
	    desplazamientos.put(Direccion.O, movOeste);
		
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
