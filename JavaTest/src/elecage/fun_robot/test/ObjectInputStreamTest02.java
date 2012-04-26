/**
 * Filename : ObjectInputStreamTest02.java
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
public class ObjectInputStreamTest02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String name = null;
		Date birthday = new Date();
		
		FileInputStream fis = new FileInputStream("c:\\test.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		name = (String)ois.readObject();
		
		birthday = (Date)ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(name);
		System.out.println(birthday);
	}

}
