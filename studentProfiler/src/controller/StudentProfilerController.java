package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import model.*;
import view.*;

public class StudentProfilerController {

	private StudentProfile model;
	private StudentProfilerFrame view;
	private MarkInputPanel MarkInput;
	private OverviewPanel Overview;
	private ProfileCreatePanel CreatePanel;
	private JTabbedPane tabPane;
	private MyMenuBar bar;
	
	public StudentProfilerController (StudentProfile model, StudentProfilerFrame view) {
		
		this.model = model;
		this.view = view;
		this.MarkInput = view.getMarkInputPanel();
		this.Overview = view.getOverviewPanel();
		this.CreatePanel = view.getProfileCreatePanel();
		this.tabPane = view.getTabPane();
		this.bar = view.getMyMenuBar();
		
		CreatePanel.populateComboBox(setupAndGetCourses());
		
		CreatePanel.addCreateListener(new CreateButtonHandler());
		MarkInput.addClearListener(new ClearButtonHandler());
		MarkInput.addSubmitListener(new SubmitButtonHandler());
		bar.addAboutItemListener(new AboutItemHandler());
		bar.addExitItemListener(new ExitItemHandler());
		bar.addLoadItemListener(new LoadItemHandler());
		bar.addSaveItemListener(new SaveItemHandler());
		
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
		  String name = ((Module) Module).getModuleName();
		  String code = ((Module) Module).getModuleCode();
		  MarkInput.setLabel(i, code , name);
		  i++;
		}
	}
	
    private class CreateButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		model.setCourse((Course)CreatePanel.getCourse().getSelectedItem());
    		model.setpNumber(CreatePanel.getpNumberInput().getText());
    		model.setStudentName(CreatePanel.getNameInput().getText());
    		updateLabelsWithModules();
    		tabPane.setSelectedIndex(1);
    	}
    }
    
    private class ClearButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		MarkInput.clearAll();
    	}
    }
	
    private class SubmitButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		submitDatatoModel();
    		tabPane.setSelectedIndex(2);
    	}
    }
    
    private class LoadItemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		model.loadFromFile();
    		CreatePanel.getNameInput().setText(model.getStudentName());
    		CreatePanel.getpNumberInput().setText(model.getpNumber());
    		
    		Course courseselected = model.getCourse();
    		if (courseselected.toString().equals("Computer Science") == true) {
    			CreatePanel.getCourse().setSelectedIndex(0);
    		} else if (courseselected.toString().equals("Software Engineering") == true) {
    			CreatePanel.getCourse().setSelectedIndex(1);
    		} else if (courseselected.toString().equals("Computer Security") == true) {
    			CreatePanel.getCourse().setSelectedIndex(2);
    		} else if (courseselected.toString().equals("Forensic Computing") == true) {
    			CreatePanel.getCourse().setSelectedIndex(3);
    		}
    		
    		updateLabelsWithModules();
    		updateView();
    	}
    }
    
    private class SaveItemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		model.saveToFile();
    	}
    }
    
    private class ExitItemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		if (JOptionPane.showConfirmDialog(bar, "Are you sure you wish to exit the application?", "Exiting Application", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    			System.exit(0);
    		}
    	}
    }
    
    private class AboutItemHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(bar, "<html><center>Student Profile Application<br>Version 1.0</center></html>", "About", 1);
    	}
    }
    
	private void submitDatatoModel() {
		
		int i = 1;
		
		Iterator<Module> iter = model.getCourse().getModules().iterator();

		while (iter.hasNext()) {
		  Object Module = iter.next();
		  String code = ((Module) Module).getModuleCode();
		  model.getCourse().getModule(code).setCwkMark(MarkInput.getCwk(i));
		  model.getCourse().getModule(code).setExamMark(MarkInput.getExam(i));
		  i++;
		}
		updateOverviewPanel();
	}
	
	private void updateView() {
		
		int i = 1;
		
		for (Module m: model.getCourse().getModules()) {
			if (m.requireResit()) {
				String code = m.getModuleCode();
				MarkInput.setCwk(i, model.getCourse().getModule(code).getCwkMark());
				MarkInput.setExam(i, model.getCourse().getModule(code).getExamMark());
				i++;
			}
		}
		
		updateOverviewPanel();
	}
	
	private void updateOverviewPanel() {
		
		String data;
		String resit = "None";
		int control = 1;
		
		data = "Name: " + model.getStudentName() + "\n";
		data += "P Number: " + model.getpNumber() + "\n";
		data += "Course: " + model.getCourse() + "\n";
		data += "\n" + "2nd Year Average:\n";
		data += "Credits passed: " + model.getCourse().creditsPassed() + "\n";
		data += "Year Average Mark: " + model.getCourse().yearAverageMark() + "\n";
		data += "\n" + "Modules Requiring Resit:";

		for (Module m: model.getCourse().getModules()) {
			if (m.requireResit()) {
				if (control == 1) {
					resit = "\n" + m.getModuleCode() + " " + m.getModuleName();
				}
				else {
					resit += "\n" + m.getModuleCode() + " " + m.getModuleName();
				}
				control++;
			}
		}
		
		data += resit;
		Overview.updateResultArea(data);
	}
}
