package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentProfile implements Serializable{

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
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Obj.ser"));) {
			StudentProfile stu = new StudentProfile();
			stu = this;
			oos.writeObject(stu);
			oos.flush();
		}
		catch (IOException ioExcep){
			System.out.println("Error saving");
		}
	}
	
	public void loadFromFile() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Obj.ser"));) {
			StudentProfile stu = new StudentProfile();
			stu = (StudentProfile) ois.readObject();
			this.setStudentName(stu.getStudentName());
			this.setpNumber(stu.getpNumber());
			this.setCourse(stu.getCourse());
		}
        catch (IOException ioExcep){
            System.out.println("Error loading");
        }
		catch (ClassNotFoundException c) {
            System.out.println("Class Not found");
        } 
	}		
	
}
