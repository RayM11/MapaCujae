package logica;

import java.io.Serializable;

public class Lugar implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String id;
	protected Coordenadas coordenadas;
	protected String foto;
	protected String fotoReverso;


	public Lugar(String id, double x, double y, String foto, String fotoReverso) {
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

	public double calcularDistanciaA(double x2, double y2){

		return Math.sqrt(Math.pow(coordenadas.getX()-x2, 2) + Math.pow(coordenadas.getY()-y2, 2));

	}

	public double calcularDistanciaA(Lugar lugarObj){

		return Math.sqrt(Math.pow(coordenadas.getX()-lugarObj.getCoordenadas().getX(), 2) + Math.pow(coordenadas.getY()-lugarObj.getCoordenadas().getY(), 2));

	}

}
