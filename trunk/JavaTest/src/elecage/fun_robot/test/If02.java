package elecage.fun_robot.test;

public class If02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(args[0]);
		if(num%2 == 1)
			System.out.println(num + "는 홀수입니다.");
		else
			System.out.println(num + "는 짝수입니다.");
	}

}
