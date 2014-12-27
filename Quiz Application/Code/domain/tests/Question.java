//new
package domain.tests;
import java.io.Serializable;
import java.util.*;

public class Question implements Serializable{

	private static int totalNumberOfQuestions;
	private int questionNumber;
	private String questionDescription;
	private ArrayList<Option> options=new ArrayList<Option>();
	private String userAnswer;
	private int numberOfOptions;


	//constructors
	public Question() {
		// TODO Auto-generated constructor stub
	}


	public Question(int questionNumber, String questionDescription,
			ArrayList<Option> options, String userAnswer, int numberOfOptions) {
		super();
		this.questionNumber = questionNumber;
		this.questionDescription = questionDescription;
		this.options = options;
		this.userAnswer = userAnswer;
		this.numberOfOptions = numberOfOptions;
	}

	//getters and setters	
	public static int getTotalNumberOfQuestions() {
		return totalNumberOfQuestions;
	}


	public static void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
		Question.totalNumberOfQuestions = totalNumberOfQuestions;
	}	



	public int getQuestionNumber() {
		return questionNumber;
	}



	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}



	public String getQuestionDescription() {
		return questionDescription;
	}



	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}



	public ArrayList<Option> getOptions() {
		return options;
	}



	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	public String getUserAnswer() {
		return userAnswer;
	}



	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public int getNumberOfOptions() {
		return numberOfOptions;
	}

	public void setNumberOfOptions(int numberOfOptions) {
		this.numberOfOptions = numberOfOptions;
	}

}
