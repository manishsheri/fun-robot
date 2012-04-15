package elecage.fun_robot.test;

public class Switch01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(args[0]);
		System.out.println("=> " + a);
		switch(a){
		case 9 :
			System.out.println("A");
		case 8:
			System.out.println("B");
		case 7:
			System.out.println("C");
		case 6:
			System.out.println("D");
		default:
			System.out.println("F");
		}
	}

}
