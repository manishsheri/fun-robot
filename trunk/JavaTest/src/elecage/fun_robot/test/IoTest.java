/**
 * Filename    : IoTest.java
 * Project     : JavaTest
 * Package     : elecage.fun_robot.test
 * Author      : elecage@gmail.com
 * Last Update : 2012. 4. 26.
 */
package elecage.fun_robot.test;

/**
 * @author khj
 *
 */
public class IoTest {
	public static void main(String args[]) throws Exception {
		int data = 0;
		
		System.out.println("���ڸ� �Է��ϼ���. �������� [ctrl]+z �� ��������.");
		data = System.in.read();
		while(data != -1) {
			if(data >= 'a' && data <='z')
				data += 'A' - 'a';
			System.out.print((char)data);
			data = System.in.read();
		}
	}
}
