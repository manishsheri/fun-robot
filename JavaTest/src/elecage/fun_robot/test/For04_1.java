package elecage.fun_robot.test;

public class For04_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, n = 0;
		int a = Integer.parseInt(args[0]);
		System.out.println("<<----- " + a + "´Ü ----->>");
		for(i = 1 ; i <= 9 ; i++)
		{
			n = a * i;
			System.out.println(a + " * " + i + " = " + n);
		}
	}

}
