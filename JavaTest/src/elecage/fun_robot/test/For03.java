package elecage.fun_robot.test;

public class For03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i ;
		
		for(i = 1 ; i <= 10 ; i++)
			System.out.print(" " + i);
		System.out.println("\n------------------------------>> ");
		
		for(i = 1 ; i <= 10 ; i += 2)
			System.out.print(" " + i);
		System.out.println("\n------------------------------>> ");
		
		for(i = 2 ; i <= 10 ; i += 2)
			System.out.print(" " + i);
		System.out.println("\n------------------------------>> ");
		
		for(i = 10 ; i >= 1 ; i--)
			System.out.print(" " + i);
		System.out.println("\n------------------------------>> ");
	}

}
