//new
package domain.tests;

import java.io.Serializable;

public class Option implements Serializable{

	private int optionNumber;
	private String optionValue;
	private boolean correctAnswer;

	//constructors
	public Option() {
		// TODO Auto-generated constructor stub
	}

	public Option(int optionNumber, String optionValue, boolean correctAnswer) {
		super();
		this.optionNumber = optionNumber;
		this.optionValue = optionValue;
		this.correctAnswer = correctAnswer;
	}
	// getters and setters
	public int getOptionNumber() {
		return optionNumber;
	}

	public void setOptionNumber(int optionNumber) {
		this.optionNumber = optionNumber;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}