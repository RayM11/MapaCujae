package logica;

import auxiliar.Validacion;

public class Facultad extends LugarDeInteres{

	private static final long serialVersionUID = 1L;

	private String decano;
	private String vicedecano;







	public Facultad(String id, double x, double y, String fotoNorte,
			String fotoSur, String fotoEste, String fotoOeste, String nombre,
			String descripcion, String anotaciones, String fotoPortada,
			String decano, String vicedecano) {
		super(id, x, y, fotoNorte, fotoSur, fotoEste, fotoOeste, nombre,
				descripcion, anotaciones, fotoPortada);
		setDecano(decano);
		setVicedecano(vicedecano);
	}
	public String getDecano() {
		return decano;
	}
	public void setDecano(String decano) {
		if(Validacion.cadenaNoVacia(decano)){  
			this.decano = decano;
		}
		else{
			throw new IllegalArgumentException ("La cadena de decano est� vac�a");
		}
	}
	public String getVicedecano() {
		return vicedecano;
	}
	public void setVicedecano(String vicedecano) {
		if(Validacion.cadenaNoVacia(vicedecano)){  
			this.vicedecano = vicedecano;
		}
		else{
			throw new IllegalArgumentException ("La cadena de vicedecano est� vac�a");
		}
	}



}


