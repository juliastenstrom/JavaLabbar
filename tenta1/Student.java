package tenta1;

import java.util.ArrayList;

public class Student {
	
	private ArrayList<MarkingSheet> theExams = new ArrayList<MarkingSheet>();
	private String firstName, secondName;
	
	public Student(String arg1, String arg2) {
		firstName = arg1;
		secondName = arg2;
	}
	
	public String getName() {return secondName;}
	
	public void addMarkingSheet(MarkingSheet arg) {
		theExams.add(arg);
	}
	
	public String toString() {
		String output = "Student: " + firstName + " " + secondName + "\n";
		
		for(int i = 0; i < theExams.size(); i++) {
			output += theExams.get(i).getExamName() + ", Grade: " +  theExams.get(i).getGrade() + "\n";
		}
		return output;
	}

}
