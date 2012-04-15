package elecage.fun_robot.test;

public class For05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		int repeat;
		String outStr = args[0];
		repeat = Integer.parseInt(args[1]);
		for(i = 1 ; i <= repeat ; i++)
			System.out.print(" " + outStr);
	}

}
