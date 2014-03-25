package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import model.*;
import view.*;

public class StudentProfilerController {

	private StudentProfile model;
	private StudentProfilerFrame view;
	private MarkInputPanel MarkInput;
	private OverviewPanel Overview;
	private ProfileCreatePanel CreatePanel;
	
	public StudentProfilerController (StudentProfile model, StudentProfilerFrame view) {
		
		this.model = model;
		this.view = view;
		this.MarkInput = view.getMarkInputPanel();
		this.Overview = view.getOverviewPanel();
		this.CreatePanel = view.getProfileCreatePanel();
		
		CreatePanel.populateComboBox(setupAndGetCourses());
		
		CreatePanel.addCreateListener(new CreateButtonHandler());
		MarkInput.addClearListener(new ClearButtonHandler());
		MarkInput.addSubmitListener(new SubmitButtonHandler());
		
	}
	
	private Course[] setupAndGetCourses() {
		
		Module ctec2121 = new Module("CTEC2121", "Organisations, Project Management and Research"); 
		Module ctec2122 = new Module("CTEC2122", "Forensics and Security"); 
		Module ctec2602 = new Module("CTEC2602", "OO Software Design and Development"); 
		Module ctec2701 = new Module("CTEC2701", "Multi-tier Web Applications"); 
		Module ctec2901 = new Module("CTEC2901", "Data Structures and Algorithms"); 
		Module lawg2003 = new Module("LAWG2003", "Issues in Criminal Justice"); 

		Course compSci = new Course("Computer Science"); 
		compSci.addModule(ctec2121); 
		compSci.addModule(ctec2602); 
		compSci.addModule(ctec2701); 
		compSci.addModule(ctec2901); 

		Course softEng = new Course("Software Engineering"); 
		softEng.addModule(ctec2121); 
		softEng.addModule(ctec2602); 
		softEng.addModule(ctec2701); 
		softEng.addModule(ctec2901); 

		Course compSecu = new Course("Computer Security"); 
		compSecu.addModule(ctec2121); 
		compSecu.addModule(ctec2122); 
		compSecu.addModule(ctec2701); 
		compSecu.addModule(ctec2901); 

		Course forenComp = new Course("Forensic Computing"); 
		forenComp.addModule(ctec2121); 
		forenComp.addModule(ctec2122); 
		forenComp.addModule(ctec2701); 
		forenComp.addModule(lawg2003); 

		Course[] courses = new Course[4]; 
		courses[0] = compSci; 
		courses[1] = softEng; 
		courses[2] = compSecu; 
		courses[3] = forenComp; 

		return courses; 
	}
	
	private void updateLabelsWithModules() {
		
		int i = 1;
		
		Iterator<Module> iter = model.getCourse().getModules().iterator();

		while (iter.hasNext()) {
		  Object Module = iter.next();
		  System.out.println(Module);
		  String name = ((Module) Module).getModuleName();
		  String code = ((Module) Module).getModuleCode();
		  MarkInput.setLabel(i, code , name);
		  i++;
		}
	}
	
    private class CreateButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		model.setCourse(CreatePanel.getSelectedCourse());
    		model.setpNumber(CreatePanel.getPNumber());
    		model.setStudentName(CreatePanel.getName());
    		updateLabelsWithModules();
    		System.out.print(model.getCourse().getModules());
    	}
    }
    
    private class ClearButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		MarkInput.clearAll();
    	}
    }
	
    private class SubmitButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    }    
}
