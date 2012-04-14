package elecage.fun_robot.test;

public class Opr08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 10;
		System.out.println(++a);
		System.out.println(a);
		
		System.out.println(b++);
		System.out.println(b);
		
		a = b = 10;
		int c;
		c = ++a;
		System.out.println(c+ "=> " + a);
		
		c = b++;
		System.out.println(c + "=>" + b);
	}

}
