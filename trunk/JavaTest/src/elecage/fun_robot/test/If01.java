package elecage.fun_robot.test;

public class If01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		num = -5;
		if(num < 0)
			num = -num;
		
		System.out.println("absolute num = " + num);
		num = 5;
		
		if(num < 0)
			num = -num;
		System.out.println("absolute num = " + num);
	}

}
