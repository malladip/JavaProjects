//new
package domain.tests;
import java.io.Serializable;
import java.util.*;

public class Test implements Serializable{

	private int numberOfQuestions;
	private float qualifyingMark;
	private int time;

	private ArrayList<Question> testQuestions=new ArrayList<Question>();


	//constructors
	public Test() {
		// TODO Auto-generated constructor stub
	}


	public Test(int numberOfQuestions, float qualifyingMark, int time,
			ArrayList<Question> testQuestions) {
		super();
		this.numberOfQuestions = numberOfQuestions;
		this.qualifyingMark = qualifyingMark;
		this.time = time;
		this.testQuestions = testQuestions;
	}

	//getters and setters

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}


	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}


	public float getQualifyingMark() {
		return qualifyingMark;
	}


	public void setQualifyingMark(float qualifyingMark) {
		this.qualifyingMark = qualifyingMark;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public ArrayList<Question> getTestQuestions() {
		return testQuestions;
	}


	public void setTestQuestions(ArrayList<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}

}