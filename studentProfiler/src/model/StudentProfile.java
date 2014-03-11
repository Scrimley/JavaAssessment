package model;

public class StudentProfile {

	private String pNumber;
	private String studentName;
	private Course course;
	
	public StudentProfile() {
		pNumber = "";
		studentName = "";
		course = null;
	}
	
	public String getpNumber() {
		return pNumber;
	}
	
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "StudentProfile:[pNumber=" + pNumber + ", studentName="
				+ studentName + ", course=" + course.actualToString() + "]";
	}
	
	
	public void saveToFile() {
		//TODO
		
	}
	
	public void loadFromFile() {
		//TODO
		
	}

	
}
