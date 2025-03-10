package tenta2;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Shape implements Comparable<Shape>{
	
	
	private static ArrayList<Shape> allShapes = new ArrayList<Shape>();
	protected double area;
	private static int counter = 0;
	private String name;
	public static int CIRCLE = 0;
	public static int SQUARE = 1;
	
	public Shape(String arg) {
		name = arg;
		counter++;
		allShapes.add(this);
	}
	
	public abstract void computeArea();
	
	
	public static String listShapes() {
		String output = "List of Shapes: \n";
		for(int i = 0; i < allShapes.size(); i++) {
			output += allShapes.get(i).toString() + "\n";
		}
		return output;
	}
	
	
	public String getName() {return name;}
	
	
	public static String sortedListing(int arg) {
		ArrayList<Circle> allCircles = new ArrayList<Circle>();
		ArrayList<Square> allSqaures = new ArrayList<Square>();

		for(int i = 0; i < allShapes.size(); i++) {
			if(allShapes.get(i) instanceof Circle) {allCircles.add((Circle) allShapes.get(i));}
			if(allShapes.get(i) instanceof Square) {allSqaures.add((Square) allShapes.get(i));}
		}
		
		if(arg == CIRCLE) {
			Collections.sort(allCircles);
			return "Sorted by Circles \n" + allCircles.toString();
		}
		
		Collections.sort(allSqaures);
		return "Sorted by Squares \n" + allSqaures.toString();
	}
	
	
	public int compareTo(Shape arg) {
		if(area < arg.area) {return -1;}
		if(area > arg.area) {return 1;}
		return 0;
	}

	
	public String toString() {
		String output = "Name: " + name + "\n" + "Area: " + area + "\n";
		
		
		return output;
	}

}
