package elecage.fun_robot.test;

public class AnimalTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a;
		a = new Animal();
		a.name = "¿ø¼þÀÌ";
		a.setAge(26);
		
		System.out.print(a.name);
		System.out.print("," + a.getAge());
	}

}
