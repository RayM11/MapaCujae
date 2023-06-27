package logica;

public class LugarDeInteres extends Lugar{

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String descripcion;
	protected String anotaciones;
	protected String fotoPortada;
	
	public LugarDeInteres(String id, double x, double y, String foto, String fotoReverso, String nombre, String descripcion, String anotaciones,String fotoPortada) {
		super(id, x, y, foto, fotoReverso);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anotaciones = anotaciones;
		this.fotoPortada = fotoPortada;
	}
	
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFotoPortada() {
		return fotoPortada;
	}
	public void setFotoPortada(String fotoPortada) {
		this.fotoPortada = fotoPortada;
	}
	
	
	
}
