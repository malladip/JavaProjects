//new
package domain.reports;

public class Report {

	private String date;
	private int testId;
	private int totalNumberOfQuestions;
	private String studentName;
	private int numberOfCorrectAns;
	private int numberOfWrongAns;
	private int numberOfPartiallyCorrect;
	float score;
	boolean result;	


	//constructors
	public Report() {
		// TODO Auto-generated constructor stub
	}


	public Report(String date, int testId, int totalNumberOfQuestions,
			String studentName, int numberOfCorrectAns, int numberOfWrongAns,
			int numberOfPartiallyCorrect, float score, boolean result) {
		super();
		this.date = date;
		this.testId = testId;
		this.totalNumberOfQuestions = totalNumberOfQuestions;
		this.studentName = studentName;
		this.numberOfCorrectAns = numberOfCorrectAns;
		this.numberOfWrongAns = numberOfWrongAns;
		this.numberOfPartiallyCorrect = numberOfPartiallyCorrect;
		this.score = score;
		this.result = result;
	}

	//setters and getters

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}


	public int getTotalNumberOfQuestions() {
		return totalNumberOfQuestions;
	}


	public void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
		this.totalNumberOfQuestions = totalNumberOfQuestions;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getNumberOfCorrectAns() {
		return numberOfCorrectAns;
	}


	public void setNumberOfCorrectAns(int numberOfCorrectAns) {
		this.numberOfCorrectAns = numberOfCorrectAns;
	}


	public int getNumberOfWrongAns() {
		return numberOfWrongAns;
	}


	public void setNumberOfWrongAns(int numberOfWrongAns) {
		this.numberOfWrongAns = numberOfWrongAns;
	}


	public int getNumberOfPartiallyCorrect() {
		return numberOfPartiallyCorrect;
	}


	public void setNumberOfPartiallyCorrect(int numberOfPartiallyCorrect) {
		this.numberOfPartiallyCorrect = numberOfPartiallyCorrect;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}


	public boolean isResult() {
		return result;
	}


	public void setResult(boolean result) {
		this.result = result;
	}

}