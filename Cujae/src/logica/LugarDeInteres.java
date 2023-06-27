package logica;

import auxiliar.Validacion;

public class LugarDeInteres extends Lugar{

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String descripcion;
	protected String anotaciones;
	protected String fotoPortada;
	
	
	public LugarDeInteres(String id, double x, double y, String fotoNorte,
			String fotoSur, String fotoEste, String fotoOeste, String nombre,
			String descripcion, String anotaciones, String fotoPortada) {
		super(id, x, y, fotoNorte, fotoSur, fotoEste, fotoOeste);
		setAnotaciones(anotaciones);
		setDescripcion(descripcion);
		setFotoPortada(fotoPortada);
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
			throw new IllegalArgumentException ("La cadena de anotaciones est� vac�a");
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
			throw new IllegalArgumentException ("La cadena de descripcion est� vac�a");
		}
	}
	public String getFotoPortada() {
		return fotoPortada;
	}
	public void setNombre(String nombre) {
		
		if(Validacion.cadenaNoVacia(nombre)){  
		this.nombre = nombre;
		}
		else{
			throw new IllegalArgumentException ("La cadena de anotaciones est� vac�a");
		}
	}

	public void setFotoPortada(String fotoPortada) {
	
		if(Validacion.cadenaNoVacia(fotoPortada)){ 
		this.fotoPortada = fotoPortada;
		}
		else{
			throw new IllegalArgumentException ("La cadena de fotoPortada est� vac�a");
		}
	}
	
	
	
}
