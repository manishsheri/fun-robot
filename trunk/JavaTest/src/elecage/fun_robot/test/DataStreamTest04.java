/**
 * Filename : DataStreamTest04.java
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
public class DataStreamTest04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ID;
		String name;
		int age;
		double height;
		
		try {
			FileInputStream fis = new FileInputStream("c:\\iotest.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			ID = dis.readInt();
			name = dis.readUTF();
			age = dis.readInt();
			height = dis.readDouble();
			
			System.out.println("ID\t name \t age \t height");
			System.out.println(ID + "\t" + name + "\t" + age + "\t" + height);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
