package logica;

import java.io.Serializable;

import auxiliar.Validacion;

public class Facultad extends LugarDeInteres implements Serializable{

	private static final long serialVersionUID = 3L;

	private String decano;



	public Facultad(String id, double x, double y, String nombre, String descripcion, String anotaciones, String decano) {

		super(id, x, y, nombre, descripcion, anotaciones);
		setDecano(decano);
		
	}

	public String getDecano() {
		return decano;
	}

	public void setDecano(String decano) {
		if(Validacion.cadenaNoVacia(decano)){  
			this.decano = decano;
		}
		else{
			throw new IllegalArgumentException ("La cadena de decano está vacía");
		}
	}


}
