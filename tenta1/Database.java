package tenta1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {
	
	private ArrayList <Student> allStudents;
	private ArrayList<Exam> allExams;
	private BufferedReader consoleReader;
	private Scanner scanner;
	
	
	
	
	public Database() {
		allStudents = new ArrayList<Student>();
		allExams = new ArrayList<Exam>();
		//consoleReader = new BufferedReader(consoleReader);
		scanner = new Scanner(System.in);
	}
	
	public void addStudent(String arg1, String arg2) {
		Student student = new Student(arg1, arg2);
		allStudents.add(student);
	}
	
	public String loadStudents(String arg1, int arg2) throws IOException {
		try {
			consoleReader = new BufferedReader(new FileReader(arg1));
			String line = consoleReader.readLine();
			do {
				String [] d = line.split(" ");
				line.split("[^\\d]+");
				addStudent(d[0], d[1]);
				line = consoleReader.readLine();
				if(line.length() < 1) {break;}
			}while(line!=null);
			consoleReader.close();
		} 
		
		catch (FileNotFoundException e) {
			return "Something went wrong";
		}
		
		return "Loaded " + arg2 + " students";
		
	}
	
	
	public String addExam(String arg1, int arg2) {
		int max = 0, min = 0;
		
		System.out.println("Maximum points possible: ");
		while(max == 0) {
			try {max = Integer.parseInt(scanner.nextLine());}
			catch (NumberFormatException ne) {return "ne Exception";}
		}
		
		System.out.println("\nMinimum points possible: ");
		while(min == 0) {
			try {min = Integer.parseInt(scanner.nextLine());}
			catch(NumberFormatException ne){return "ne Exception";}
		}
		
		Exam exam = new Exam(arg1, arg2, min, max);
		allExams.add(exam);
		String output = "Course " + arg1 + " added";
		return output;
	}
	
	
	public String checkStudent(int arg) {
		if(arg <= allStudents.size()) {return allStudents.get(arg).toString();}
		return "Students does not exist";
	}
	
	
	public String checkExam(int arg) {
		if(arg <= allExams.size()) {return allExams.get(arg).toString();}
		return "Exam does not exist";
	}
	
	
	
	
	public String MarkStudent(String arg1, int arg2, int arg3) {
		String output = "Could not create marking sheet";
		Student nameStudent = new Student(" ", " ");
		String test = "";
		
		for(int i = 0; i < allStudents.size(); i++) {
			if(arg1.equals(allStudents.get(i).getName())) {
				nameStudent = allStudents.get(i);
				test = " ";
				break;
			}
			else {
				test =  "Student does not exist";
			}
		}
		
		Exam exam = new Exam("", 0, 0, 0);
		for(int i = 0; i < allExams.size(); i++) {
			if(arg2 == allExams.get(i).getCode()) {
				exam = allExams.get(i);
				break;
			}
		}
	
		if(test.equals("Student does not exist") || arg3 > exam.getMaxPoints()) {
			return "Could not create marking sheet";
		}
		
		else {
			String grade = "U";
			MarkingSheet mark = new MarkingSheet(arg2, exam, nameStudent);
			nameStudent.addMarkingSheet(mark);
			exam.addMarkedStudent(mark);
			
			if(arg3 >= exam.getMinPoints()) {
				grade = "G";
			}
			mark.setGrade(grade);
			
			output = String.format("Student: %s got the grade %s", nameStudent.getName(), grade); 
			
		}
		return output;
	}
	
	
	public String toString() {
		String output = "Students \n";
		for(int i = 0; i < allStudents.size(); i++) {
			output += allStudents.get(i).getName() + "\n";
		}
		
		output += "\n";
		
		for(int i = 0; i < allExams.size(); i++) {
			output += allExams.get(i).getName() + "\n";
		}
		return output;

	}


}
