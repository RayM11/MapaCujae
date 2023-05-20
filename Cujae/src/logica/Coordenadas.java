package logica;

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

	
	public Direccion direccionHacia(Coordenadas cor2) throws IllegalArgumentException{
		
		Direccion dir;
		
		float difY = y - cor2.getY();
		float difX = x - cor2.getX();
		
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
			throw new IllegalArgumentException("Movimiento diagonal intentado, situación no contemplada todavía");
				
		return dir;
	}
	
	private float abs(float num){
		
		if (num < 0)
			num *= -1;
		
		return num;
	}

}
