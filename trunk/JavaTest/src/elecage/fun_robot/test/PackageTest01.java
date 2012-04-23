package elecage.fun_robot.test;

import java.util.*;
public class PackageTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("0 - 100 범위의 숫자는 " + r.nextInt(100));
		}

	}

}
