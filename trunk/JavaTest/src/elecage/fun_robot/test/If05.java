package elecage.fun_robot.test;

public class If05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = Integer.parseInt(args[0]);
		System.out.print(score + "��");
		if(score >= 90 && score <= 100)
			System.out.println("A����");
		else if(score >= 80 && score <=89)
			System.out.println("B����");
		else if(score >= 70 && score <= 79)
			System.out.println("C����");
		else if(score >= 60 && score <= 69)
			System.out.println("D����");
		else
			System.out.println("F����");
	}

}
