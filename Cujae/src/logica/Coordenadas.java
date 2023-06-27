package logica;

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

	
	public Direccion direccionHacia(Coordenadas cor2) throws IllegalArgumentException{
		
		Direccion dir;
		
		double difY = y - cor2.getY();
		double difX = x - cor2.getX();
		
		if (abs(difY) > abs(difX))
		
			if (difY > 0)
				dir = Direccion.S;
			else
				dir = Direccion.N;
			
		else if (abs(difY) < abs(difX))
			if (difX > 0)
				dir = Direccion.O;
			else
				dir = Direccion.E;
		else
			throw new IllegalArgumentException("Movimiento diagonal intentado, situaci�n no contemplada todav�a");
				
		return dir;
	}
	
	private double abs(double num){
		
		if (num < 0)
			num *= -1;
		
		return num;
	}

}
