package logica;

import java.io.Serializable;

public class Lugar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private Coordenadas coordenadas;
	private String foto;
	private String fotoReverso;
	
	
	public Lugar(String id, float x, float y, String foto) {
		this.id = id;
		this.foto = foto;
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
	public String getFotoReverso() {
		return fotoReverso;
	}
	public void setFotoReverso(String fotoReverso) {
		this.fotoReverso = fotoReverso;
	}
	
}
