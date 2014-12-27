//new
package domain.users;
import domain.reports.Report;
import java.util.*;

public class Student extends User {
	private String studentName;
	private	Date  dateOfBirth;
	private String collegeName;
	private	String qualification;
	private List<Report> report;

	public Student() {

	}


	public Student(String studentName, Date dateOfBirth, String collegeName,
			String qualification, List<Report> report, String userName,
			String password) {
		super();
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.collegeName = collegeName;
		this.qualification = qualification;
		this.report = report;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public List<Report> getReport() {
		return report;
	}


	public void setReport(List<Report> report) {
		this.report = report;
	}

}

