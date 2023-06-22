package auxiliar;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Usuario {

	private ArrayList<byte[]> nombre;
	private ArrayList<byte[]> pass;
	private File admin;


	public Usuario(){
		nombre = new ArrayList<byte[]>();
		pass = new ArrayList<byte[]>();
		admin = new File("Res/admin.dat");
	}

	public void leerCredencialesEncriptados(){

		try {

			RandomAccessFile raf = new RandomAccessFile(admin, "r");

			int tamNombre = raf.readInt();
			int tamPass = raf.readInt();

			for(int i = 0; i < tamNombre || i < tamPass;i++){
				
				if(i < tamNombre)
					nombre.add(null);
				if(i < tamPass)
					pass.add(null);
				
			}

			int cont = 0;

			while(cont < tamNombre){

				byte[] arrFC = new byte[raf.readInt()];
				raf.read(arrFC);
				FragmentoCredencial fC = (FragmentoCredencial) Convert.toObject(arrFC);
				nombre.set(fC.getPos(), fC.getFragmento());
				cont++;
			}
			cont = 0;
			while(cont < tamPass){

				byte[] arrFC = new byte[raf.readInt()];
				raf.read(arrFC);
				FragmentoCredencial fC = (FragmentoCredencial) Convert.toObject(arrFC);
				pass.set(fC.getPos(), fC.getFragmento());
				cont++;
			}

			raf.close();

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
			RandomAccessFile raf = new RandomAccessFile(admin, "rw");
			raf.setLength(0);

			int posNombre = 0;
			int posPass = 0;

			raf.writeInt(0);
			raf.writeInt(0);

			for(int i = 0; i < nombre.length(); i += 2){

				subString = nombre.substring(i, Math.min(i+2,nombre.length()));
				n.add(new FragmentoCredencial(Convert.toBytes(subString), posNombre));
				posNombre++;
			}
			Collections.shuffle(n);

			for(FragmentoCredencial fragmentoCredencial:n){

				byte[] arr = Convert.toBytes(fragmentoCredencial);
				raf.writeInt(arr.length);
				raf.write(arr);

			}

			for(int i = 0; i < pass.length(); i += 2){

				subString = pass.substring(i, Math.min(i+2,pass.length()));
				p.add(new FragmentoCredencial(Convert.toBytes(subString), posPass));
				posPass++;
			}
			Collections.shuffle(p);

			for(FragmentoCredencial fragmentoCredencial:p){

				byte[] arr = Convert.toBytes(fragmentoCredencial);
				raf.writeInt(arr.length);
				raf.write(arr);

			}
			
			raf.seek(0);
			raf.writeInt(posNombre);
			raf.writeInt(posPass);

			raf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
