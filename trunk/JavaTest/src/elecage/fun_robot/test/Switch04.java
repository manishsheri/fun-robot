package elecage.fun_robot.test;

public class Switch04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = args[0];
		char ch;
		ch = str.charAt(0);
		switch(ch){
		case 'A':
		case 'a':
			System.out.println("America");
			break;
		case 'B':
		case 'b':
			System.out.println("Britain");
			break;
		case 'C':
		case 'c':
			System.out.println("China");
			break;
		case 'J':
		case 'j':
			System.out.println("Japan");
			break;
		case 'K':
		case 'k':
			System.out.println("Korea");
			break;
		}
	}

}
