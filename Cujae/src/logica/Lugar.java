package logica;

import java.io.File;
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


	public String getFotoDir(Direccion dir){

		String foto = "fotos/visita/"+id + dir.toString()+".jpg";
		File file = new File(foto);
		if(!file.exists())
			foto = elegirDirFotoFaltante(dir);

		return foto;
	}

	private String elegirDirFotoFaltante(Direccion dir) {

		String foto = "/texturas/FotoNoEncontrada";
		switch (dir.ordinal()) {
		case 0:
			foto = foto+"N.jpg";
			break;
		case 1:
			foto = foto+"S.jpg";
			break;
		case 2:
			foto = foto+"E.jpg";
			break;
		case 3:
			foto = foto+"O.jpg";
			break;
		}

		return foto;
	}
	public double calcularDistanciaA(double x2, double y2){

		return Math.sqrt(Math.pow(coordenadas.getX()-x2, 2) + Math.pow(coordenadas.getY()-y2, 2));

	}

	public double calcularDistanciaA(Lugar lugarObj){

		return Math.sqrt(Math.pow(coordenadas.getX()-lugarObj.getCoordenadas().getX(), 2) + Math.pow(coordenadas.getY()-lugarObj.getCoordenadas().getY(), 2));

	}

}
