package elecage.fun_robot.test;

public class For07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i ; 
		int n;
		int fac = 1;
		
		n = Integer.parseInt(args[0]);
		
		for(i = 1 ; i <= n ; i++)
			fac *= i;
		
		System.out.println(n + "! ------------>> " + fac);
	}

}
