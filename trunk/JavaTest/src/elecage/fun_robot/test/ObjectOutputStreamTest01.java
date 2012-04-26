/**
 * Filename : ObjectOutputStreamTest01.java
 * Project  : JavaTest
 * Package  : elecage.fun_robot.test
 * Author   : khj
 * Date     : 2012. 4. 26.
 */
package elecage.fun_robot.test;

import java.io.*;
import java.util.*;

/**
 * @author khj
 *
 */
public class ObjectOutputStreamTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = new String("¼ºÀ±Á¤");
		Date birthday = new Date();
	
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\test.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(name);
			oos.writeObject(birthday);
			oos.flush();
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
