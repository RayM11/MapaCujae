package logica;

import java.io.Serializable;

import auxiliar.Validacion;

public class Lugar implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String id;
	protected Coordenadas coordenadas;
	protected String fotoNorte;
	protected String fotoSur;
	protected String fotoEste;
	protected String fotoOeste;
	


	public Lugar(String id, double x, double y, String fotoNorte , String fotoSur ,String fotoEste , String fotoOeste) {
		setId(id);
		setFotoNorte(fotoNorte);
		setFotoSur(fotoSur);
		
		coordenadas = new Coordenadas(x, y);
		
	}

	public String getId() {
		return id;
	}
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}
	public String getFotoNorte(){
		return fotoNorte;
	}
	public void setFotoNorte(String fotoNorte) {
		
	
		if(Validacion.cadenaNoVacia(fotoNorte)){  
			this.fotoNorte = fotoNorte;
		}
		else{
			throw new IllegalArgumentException ("La URL de la foto Norte est� vac�a");
		}
	}
	public void setFotoEste(String fotoEste) {
		
		
		if(Validacion.cadenaNoVacia(fotoEste)){  
			this.fotoEste = fotoEste;
		}
		else{
			throw new IllegalArgumentException ("La URL de la foto este est� vac�a");
		}
	}
	public String getFotoSur() {
		return fotoSur;
	}
	public void setFotoSur(String fotoSur) {
		
		if(Validacion.cadenaNoVacia(fotoSur)){   
			this.fotoSur = fotoSur;
		}
		else{
			throw new IllegalArgumentException ("La URL de la foto sur  est� vac�a");
		}
	}
	
public void setFotoOeste(String fotoOeste) {
		
		if(Validacion.cadenaNoVacia(fotoOeste)){   
			this.fotoOeste = fotoOeste;
		}
		else{
			throw new IllegalArgumentException ("La URL de la foto oeste   est� vac�a");
		}
	}

	public String getFotoEste() {
	return fotoEste;
}

public String getFotoOeste() {
	return fotoOeste;
}

	public void setId(String id) {
		
		if(Validacion.cadenaNoVacia(id)){  
			this.id = id;
		}
		else{
			throw new IllegalArgumentException ("La cadena del id est� vac�a");
		}
	}

	public double calcularDistanciaA(double x2, double y2){

		return Math.sqrt(Math.pow(coordenadas.getX()-x2, 2) + Math.pow(coordenadas.getY()-y2, 2));

	}

}
