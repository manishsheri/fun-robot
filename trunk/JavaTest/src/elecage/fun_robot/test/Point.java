package elecage.fun_robot.test;

public class Point {
	int x, y;
	public Point(){}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		String str;
		str = "( " + x + ", " + y + " )";
		return str;
	}
}
