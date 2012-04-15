package elecage.fun_robot.test;

public class If03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		int max, min;
		
		if(a > b){
			max = a;
			min = b;
		}
		else{
			max = b;
			min = a;
		}
		
		System.out.println("최대값은 " + max + "입니다.");
		System.out.println("최소값은 " + min + "입니다.");
	}

}
