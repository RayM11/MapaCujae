package auxiliar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
}


