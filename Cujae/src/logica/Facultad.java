package logica;

public class Facultad extends LugarDeInteres{
	
	private static final long serialVersionUID = 1L;
	
	private String decano;
	private String vicedecano;
	
	
	
	public Facultad(String id, float x, float y, String foto, String nombre, String descripcion, String decano, String vicedecano) {
		super(id, x, y, foto, nombre, descripcion);
		
		this.decano = decano;
		this.vicedecano = vicedecano;
	}
	
	
	
	public String getDecano() {
		return decano;
	}
	public void setDecano(String decano) {
		this.decano = decano;
	}
	public String getVicedecano() {
		return vicedecano;
	}
	public void setVicedecano(String vicedecano) {
		this.vicedecano = vicedecano;
	}
	
	

}
