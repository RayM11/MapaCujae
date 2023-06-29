package logica;

import java.io.Serializable;

import auxiliar.Validacion;

public class LugarDeInteres extends Lugar implements Serializable{

	private static final long serialVersionUID = 2L;
	protected String nombre;
	protected String descripcion;
	protected String anotaciones;
	
	public LugarDeInteres(String id, double x, double y, String nombre, String descripcion, String anotaciones) {
		super(id, x, y);
		setAnotaciones(anotaciones);
		setDescripcion(descripcion);
		setNombre(nombre);
	}
	
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		
		if(Validacion.cadenaNoVacia(anotaciones)){  
		this.anotaciones = anotaciones;
		}
		else{
			throw new IllegalArgumentException ("La cadena de descripcion está vacía");
		}
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
	
		if(Validacion.cadenaNoVacia(descripcion)){   
		this.descripcion = descripcion;
		}
		else{
			throw new IllegalArgumentException ("La cadena de descripcion está vacía");
		}
	}
	public void setNombre(String nombre) {
		
		if(Validacion.cadenaNoVacia(nombre)){  
		this.nombre = nombre;
		}
		else{
			throw new IllegalArgumentException ("La cadena de anotaciones está vacía");
		}
	}
}
