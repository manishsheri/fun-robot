package elecage.fun_robot.test;

public class AnimalTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a;
		a = new Animal();
		a.name = "¿ø¼þÀÌ";
		a.age = 26;
		
		System.out.print(a.name);
		System.out.print(", " + a.age);
	}

}
