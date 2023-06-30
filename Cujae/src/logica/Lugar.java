package logica;

import java.io.Serializable;

import auxiliar.Direccion;

public class Lugar implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String id;
	protected Coordenadas coordenadas;


	public Lugar(String id, double x, double y) {
		this.id = id;
		coordenadas = new Coordenadas(x, y);
	}
	public String getId(){
		return id;
	}
	
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}
	
	public String getFoto(){
		
		return "fotos/portadas/"+id + "D.jpg";
	}
	
	public String getFotoDir(Direccion dir){
		
		return "fotos/visita/"+id + dir.toString()+".jpg";
	}

	public double calcularDistanciaA(double x2, double y2){

		return Math.sqrt(Math.pow(coordenadas.getX()-x2, 2) + Math.pow(coordenadas.getY()-y2, 2));

	}

	public double calcularDistanciaA(Lugar lugarObj){

		return Math.sqrt(Math.pow(coordenadas.getX()-lugarObj.getCoordenadas().getX(), 2) + Math.pow(coordenadas.getY()-lugarObj.getCoordenadas().getY(), 2));

	}

}
