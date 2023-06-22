package auxiliar;

import java.io.Serializable;

public class ConexionesVertex implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Object info;
	private int[] indexConecciones;
	
	public ConexionesVertex(Object info, int[] indexConecciones) {
		
		this.info = info;
		this.indexConecciones = indexConecciones;
		
	}

	public Object getInfo() {
		return info;
	}

	public int[] getIndexConecciones() {
		return indexConecciones;
	}
	
}
