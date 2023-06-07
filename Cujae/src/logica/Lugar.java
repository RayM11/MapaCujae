package logica;

import java.io.Serializable;

public class Lugar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String id;
	protected Coordenadas coordenadas;
	protected String foto;
	protected String fotoReverso;
	
	
	public Lugar(String id, float x, float y, String foto, String fotoReverso) {
		this.id = id;
		this.foto = foto;
		this.fotoReverso = fotoReverso;
		coordenadas = new Coordenadas(x, y);
	}
	
	public String getId() {
		return id;
	}
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}
	public String getFoto(){
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFotoReverso() {
		return fotoReverso;
	}
	public void setFotoReverso(String fotoReverso) {
		this.fotoReverso = fotoReverso;
	}
	
}
