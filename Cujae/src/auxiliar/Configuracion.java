package auxiliar;

public class Configuracion {
	
	private String temaLAF;
	private String temaLAFnombre;
	private boolean esAdmin;
	private int tamanoFuente;
	private String tamanoFuenteNombre;
	
	//los ajustes que sean implementados en un futuro serán guardados aquí también

	
	
	// Configuracion por defecto del programa
	public Configuracion(){
		setEsAdmin(true);
		setTemaLAF("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		setTemaLAFnombre("Acryl");
		setTamanoFuente(15);
		setTamanoFuenteNombre("Mediano");
		
		
	}
	
	// Configuracion específica
	public void guardarConfiguracion(String temaLAF, String temaLAFnombre, int tamanoFuente, String tamanoFuenteNombre){
		setTemaLAF(temaLAF);
		setTemaLAFnombre(temaLAFnombre);
		setTamanoFuente(tamanoFuente);
		setTamanoFuenteNombre(tamanoFuenteNombre);
	}
	
	
	public void setEsAdmin(boolean esAdmin){
		this.esAdmin = esAdmin;
	}
	public boolean getEsAdmin(){
		return esAdmin;
	}
	public String getTemaLAFnombre(){
		return temaLAFnombre;
	}
	public void setTemaLAFnombre (String temaLAFnombre){
		if (temaLAFnombre != null)
			this.temaLAFnombre = temaLAFnombre;
	}
	public String getTemaLAF(){
		return temaLAF;
	}
	public void setTemaLAF (String temaLAF){
			this.temaLAF = temaLAF;
	}
	
	public String getTamanoFuenteNombre(){
		return tamanoFuenteNombre;
	}
	public void setTamanoFuenteNombre(String tamanoFuenteNombre){
		if (tamanoFuenteNombre != null)
		this.tamanoFuenteNombre = tamanoFuenteNombre;
	}
	public int getTamanoFuente(){
		return tamanoFuente;
	}
	public void setTamanoFuente(int tamanoFuente){
			this.tamanoFuente = tamanoFuente;
	}
	
	
}
