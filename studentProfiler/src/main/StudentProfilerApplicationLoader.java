package main;

import controller.StudentProfilerController;
import model.StudentProfile;
import view.StudentProfilerFrame;

public class StudentProfilerApplicationLoader {
	
	public static void main(String[] args) {
		
		StudentProfile model = new StudentProfile();
		StudentProfilerFrame view = new StudentProfilerFrame();
		StudentProfilerController controller = new StudentProfilerController(model, view);
		
	}
}
