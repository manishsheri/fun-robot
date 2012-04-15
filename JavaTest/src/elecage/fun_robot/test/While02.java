package elecage.fun_robot.test;

public class While02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while(i++ <= 4)
			System.out.print(i + ", ");
		System.out.println("\n------------------------->>");
		
		i = 1;
		while(++i <= 4)
			System.out.print(i + ", ");
		System.out.println("\n------------------------->>");
		
		i = 0;
		while(i++ <= 4)
			System.out.print(i + ", ");
		System.out.println("\n------------------------->>");
	}

}
