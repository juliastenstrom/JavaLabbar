package tenta2;

public class Square extends Shape{

	private static Square currentSqaure;
	private Square previousSquare;
	private double length;
	
	public Square(double arg) {
		super("Square");
		length = arg;
		computeArea();
	}

	public static Square getCurrentCircle() {return currentSqaure;}
	
	public Square getPreviousCircle() {return previousSquare;}
	
	public void computeArea() {
		area = length * length;
	}
	
}
