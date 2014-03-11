package model;

public class Module {
	
	private String moduleCode;
	private String moduleName;
	private int examMark;
	private int cwkMark;
	
	public Module(String moduleCode, String moduleName) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		examMark = 0;
		cwkMark = 0;
	}
	
	public Module(String moduleCode, String moduleName, int examMark, int cwkMark) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.examMark = examMark;
		this.cwkMark = cwkMark;
	}
	
	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getExamMark() {
		return examMark;
	}
	
	public void setExamMark(int examMark) {
		this.examMark = examMark;
	}

	public int getCwkMark() {
		return cwkMark;
	}
	
	public void setCwkMark(int cwkMark) {
		this.cwkMark = cwkMark;
	}
	
	public int getModuleMark() {
		return (int) Math.round(((examMark + cwkMark) / 2.0));
	}
	
	public boolean requireResit() {
		return this.getModuleMark() < 40;
	}

	@Override
	public String toString() {
		return "Module:[moduleCode=" + moduleCode + ", moduleName="
				+ moduleName + ", examMark=" + examMark + ", cwkMark=" + cwkMark + "]";
	}
	
}
