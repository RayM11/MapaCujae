package auxiliar;

import java.util.ArrayList;

public class Validacion {
	
	public static boolean cadenaNoVacia(String cadena){
		boolean noVacia = true;
		
		if(cadena == null || cadena.replaceAll("\\s+", "").isEmpty()){
			noVacia = false;
		}
		
		return noVacia;
	}
	
	public static boolean listaCadenasNoVacias(ArrayList<String> listaCadenas){
		boolean todasLasCadenasNoVacias = true;
		
		for (int i = 0; i < listaCadenas.size() && todasLasCadenasNoVacias; i ++ ){
	
			todasLasCadenasNoVacias = cadenaNoVacia(listaCadenas.get(i));
		
		}
		return todasLasCadenasNoVacias;
	}
	
	
	
	public static boolean tieneCaracterNumerico(String cadena){
		boolean tiene = false;
		
		for(int i = 0; i < cadena.length() && !tiene; i ++){
			if(Character.isDigit(cadena.charAt(i))){
				tiene = true;
			}
		}
		
		return tiene;
	}
	
	

}
