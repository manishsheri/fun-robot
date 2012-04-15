package elecage.fun_robot.test;

public class If04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(args[0]);
		if(a > 0)
			System.out.println(a + "는 양수입니다.");
		else if(a < 0)
			System.out.println(a + "는 음수입니다.");
		else
			System.out.println("0입니다.");
	}

}
