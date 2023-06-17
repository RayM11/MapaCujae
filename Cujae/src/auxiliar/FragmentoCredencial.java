package auxiliar;

import java.io.Serializable;

public class FragmentoCredencial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private byte[] fragmento;
	private int pos;
	
	public FragmentoCredencial(byte[] fragmento, int pos) {
		
		this.fragmento = fragmento;
		this.pos = pos;
		
	}

	public byte[] getFragmento() {
		return fragmento;
	}

	public int getPos() {
		return pos;
	}
	
	

}
