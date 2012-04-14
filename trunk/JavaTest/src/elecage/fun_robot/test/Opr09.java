package elecage.fun_robot.test;

public class Opr09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 20;
		int c;
		c = a & b;
		System.out.println(a + " & " + b + " -> " + c);
		
		c = a | b;
		System.out.println(a + " | " + b + " -> " + c);
		
		c = a ^ b;
		System.out.println(a + " ^ " + b + " -> " + c);
		
		c = ~a;
		System.out.println(" ~" + a + " -> " + c);
	}

}
