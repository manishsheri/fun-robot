/**
 * Filename : DataStreamTest03.java
 * Project  : JavaTest
 * Package  : elecage.fun_robot.test
 * Author   : khj
 * Date     : 2012. 4. 26.
 */
package elecage.fun_robot.test;

import java.io.*;
/**
 * @author khj
 *
 */
public class DataStreamTest03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ID = 1;
		String name = "¼ºÀ±Á¤";
		int age = 25;
		double height = 165.6;
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\iotest.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeInt(ID);
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			
			dos.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
