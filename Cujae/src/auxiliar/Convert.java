package auxiliar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Convert
{
	public static byte[] toBytes(Object object)
			throws IOException
			{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		return baos.toByteArray();
			}

	public static Object toObject(byte[] bytes)
			throws IOException, ClassNotFoundException
			{
		Object object = null;
		object = new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
		return object;
			}

	public static byte[] intToBytes(int integer) throws IOException{

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(integer);
		dos.close();
		baos.close();
		return baos.toByteArray();

	}

	public static int toInt(byte[] bytes)
			throws IOException
			{
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bais);
		int integer = dis.readInt();
		dis.close();
		bais.close();
		return integer;
			}

	public static ImageIcon rezizarImagen(String imagen, int ancho, int alto){

		return new ImageIcon(resizarImage(imagen, ancho, alto));

	}
<<<<<<< Updated upstream
=======

	public static Image resizarImage(String imagen, int ancho, int alto){

		Image resizedImage = null;
		
		try {

			File file = new File(imagen);
			BufferedImage bi = ImageIO.read(file);
			resizedImage = bi.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resizedImage;	
	}


	public static ImageIcon resizarURL(URL url, int ancho, int alto) {

		return new ImageIcon(resizarURLImage(url, ancho, alto));

	}
	
	public static Image resizarURLImage(URL url, int ancho, int alto) {

		Image imagenRedimensionada = null;
		try {
			Image imagen = ImageIO.read(url);
			imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			e.printStackTrace();
		}


		return imagenRedimensionada;

	}
	
	

>>>>>>> Stashed changes
}