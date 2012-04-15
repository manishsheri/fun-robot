package elecage.fun_robot.test;

public class While04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int tot = 0;
		n = 0;
		while(n <= 8){
			n += 2;
			tot += n;
		}
		
		System.out.println("tot = " + tot);
	}

}
