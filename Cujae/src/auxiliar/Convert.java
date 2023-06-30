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

		ImageIcon icono = null;
		
		try {
			
			File file = new File(imagen);
			BufferedImage bi = ImageIO.read(file);
			Image resizedImage = bi.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
			icono = new ImageIcon(resizedImage);

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return icono;

	}
}