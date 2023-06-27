package auxiliar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Usuario {

	private ArrayList<byte[]> nombre;
	private ArrayList<byte[]> pass;
	private String filePath;


	public Usuario(){
		nombre = new ArrayList<byte[]>();
		pass = new ArrayList<byte[]>();
		filePath = "admin.dat";
	}

	public void leerCredencialesEncriptados(){

		try {
			

			FileInputStream in = new FileInputStream("Res/admin.dat");
			
			in.getChannel().position(0);

			byte[] arrTamNombre = new byte[4];
			in.read(arrTamNombre);
			int tamNombre = Convert.toInt(arrTamNombre);

			byte[] arrTamPass = new byte[4];
			in.read(arrTamPass);
			int tamPass = Convert.toInt(arrTamPass);

			for(int i = 0; i < tamNombre || i < tamPass;i++){

				if(i < tamNombre)
					nombre.add(null);
				if(i < tamPass)
					pass.add(null);

			}

			int cont = 0;

			while(cont < tamNombre){

				byte[] tamArr = new byte[4];
				in.read(tamArr);
				int tam = Convert.toInt(tamArr);

				byte[] arrFC = new byte[tam];
				in.read(arrFC);
				FragmentoCredencial fC = (FragmentoCredencial) Convert.toObject(arrFC);
				nombre.set(fC.getPos(), fC.getFragmento());
				cont++;
			}
			cont = 0;
			while(cont < tamPass){

				byte[] tamArr = new byte[4];
				in.read(tamArr);
				int tam = Convert.toInt(tamArr);

				byte[] arrFC = new byte[tam];
				in.read(arrFC);
				FragmentoCredencial fC = (FragmentoCredencial) Convert.toObject(arrFC);
				pass.set(fC.getPos(), fC.getFragmento());
				cont++;
			}

			in.close();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String getNombre() throws ClassNotFoundException, IOException{
		String n = "";

		for(byte[] bs:nombre){
			if(bs != null){
				n += (String)Convert.toObject(bs);
			}
			else
				throw new NullPointerException("Nombre corrupto");
		}

		return n;
	}

	public String getPass() throws ClassNotFoundException, IOException{
		String p = "";

		for(byte[] bs:pass){
			if(bs != null){
				p += (String)Convert.toObject(bs);
			}
			else
				throw new NullPointerException("Contraseña corrupta");
		}

		return p;
	}

	// Metodo para cambiar el Admin (usar en la clase Iniciadora)//

	public void crearAdmin(String nombre, String pass){

		ArrayList<FragmentoCredencial> n = new ArrayList<FragmentoCredencial>();
		ArrayList<FragmentoCredencial> p = new ArrayList<FragmentoCredencial>();
		String subString = null;

		try {

			FileOutputStream out = new FileOutputStream("Res/admin.dat");

			int contNombre = 0;
			int contPass = 0;

			byte[] arrAux = Convert.intToBytes(0);

			out.write(arrAux);
			out.write(arrAux);

			for(int i = 0; i < nombre.length(); i += 2){

				subString = nombre.substring(i, Math.min(i+2,nombre.length()));
				n.add(new FragmentoCredencial(Convert.toBytes(subString), contNombre));
				contNombre++;
			}
			Collections.shuffle(n);

			for(FragmentoCredencial fragmentoCredencial:n){

				byte[] arr = Convert.toBytes(fragmentoCredencial);
				byte[] tam = Convert.intToBytes(arr.length);
				out.write(tam);
				out.write(arr);

			}

			for(int i = 0; i < pass.length(); i += 2){

				subString = pass.substring(i, Math.min(i+2,pass.length()));
				p.add(new FragmentoCredencial(Convert.toBytes(subString), contPass));
				contPass++;
			}
			Collections.shuffle(p);

			for(FragmentoCredencial fragmentoCredencial:p){

				byte[] arr = Convert.toBytes(fragmentoCredencial);
				byte[] tam = Convert.intToBytes(arr.length);
				out.write(tam);
				out.write(arr);

			}

			out.getChannel().position(0);
			byte[] arrContNombre = Convert.intToBytes(contNombre);
			out.write(arrContNombre);
			byte[] arrContPass = Convert.intToBytes(contPass);
			out.write(arrContPass);

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
