package tenta1;

public class MarkingSheet {
	
	private int code;
	private String grade;
	private Exam theExam;
	private Student theStudent;
	
	
	public MarkingSheet(int arg1, Exam arg2, Student arg3) {
		code = arg1;
		theExam = arg2;
		theStudent = arg3;
	}
	
	public void setGrade(String arg) {
		grade = arg;
	}
	
	public int getCode() {return code;}
	
	public String getGrade() {return grade;}
	
	public String getExamName() {return theExam.getName();}
	
	public String getStudentName() {return theStudent.getName();}
	
	public String toString() {
		
		String output = "Student: " + getStudentName() + " Grade" + getGrade() + "\n";
		return output;
	}




}
