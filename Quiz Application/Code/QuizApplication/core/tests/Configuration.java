//new1

package core.tests;
import domain.tests.Option;

import domain.tests.Test;
import domain.tests.Question;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Configuration{

	ArrayList<Question> questions=new ArrayList<Question>();

	public void setTestDetails(){

		try
		{
			FileInputStream fis=new FileInputStream("QuestionBank.odt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			questions= (ArrayList<Question>) ois.readObject();	
			ois.close();

		} catch(Exception e){

		}

		System.out.println("Currently there are "+questions.size()+" questions in the QuestionBank");


		Test test=new Test();

		Scanner dis=new Scanner(System.in);
		System.out.println("enter number of questions for the Quiz");
		int x=Integer.parseInt(dis.nextLine());
		if(x<=questions.size()){
			test.setNumberOfQuestions(x);
			System.out.println("enter qualifing mark");
			test.setQualifyingMark(Float.parseFloat(dis.nextLine()));
			System.out.println("enter max test time in min");
			test.setTime(Integer.parseInt(dis.nextLine()));


			try
			{
				FileOutputStream fos=new FileOutputStream("TestDetails.odt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(test);
				oos.close();

			} catch(Exception e){
				e.printStackTrace();	
			}

		}else{
			System.out.println("Number of questions in the Quiz can not exceed "+questions.size());
			System.out.println("enter number of questions for the Quiz");
			x=Integer.parseInt(dis.nextLine());
			test.setNumberOfQuestions(x);

			if(x>questions.size()){
				System.out.println("This will cause an error while taking the test\nPlease reconfigure the Test");
			}else{
				System.out.println("enter qualifing mark");
				test.setQualifyingMark(Float.parseFloat(dis.nextLine()));
				System.out.println("enter max test time in min");
				test.setTime(Integer.parseInt(dis.nextLine()));

				try
				{
					FileOutputStream fos=new FileOutputStream("TestDetails.odt");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(test);
					oos.close();

				} catch(Exception e){
					e.printStackTrace();	
				}
			}
		}

	}

	public void createQuestionBank(){

		try
		{


			FileInputStream fis=new FileInputStream("QuestionBank.odt");
			ObjectInputStream ois=new ObjectInputStream(fis);

			questions= (ArrayList<Question>) ois.readObject();	
			ois.close();

		} catch(Exception e){
		}

		System.out.println("Currently there are "+questions.size()+" questions in the QuestionBank");

		createQuestion();
	}

	public void createQuestion(){

		questions.add(readQuestion());

		Scanner s =new Scanner(System.in);
		System.out.println("do you want to add one more question?(y/n)");
		String a= s.nextLine();
		if(a.equals("y")) createQuestion();
		else{

			try
			{
				FileOutputStream fos=new FileOutputStream("QuestionBank.odt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(questions);
				oos.close();

			} catch(Exception e){
				e.printStackTrace();

			}

		}
	}

	public Question readQuestion(){

		Question question=new Question();

		ArrayList<Option> options=new ArrayList<Option>();

		Scanner dis=new Scanner(System.in);

		question.setQuestionNumber( ( Question.getTotalNumberOfQuestions() ) + 1);
		try{
			System.out.println("enter the question description");

			question.setQuestionDescription(dis.nextLine());
			System.out.println("enter number of options you want for this question");

			question.setNumberOfOptions(Integer.parseInt(dis.nextLine()));

			System.out.println("enter "+question.getNumberOfOptions()+" options for the questions");

			for(int i=0;i<(question.getNumberOfOptions());i++)
			{
				Option op=new Option();

				readOption(i,op);
				options.add(op);
				op.setOptionNumber(i+1);

			}

			question.setOptions(options);
		}
		catch(NumberFormatException ne){
			System.out.println("Invalid entry");
			System.out.println("The question is not saved");
			 question = readQuestion();
			
		}	
		return question;
	}

	public void readOption(int i,Option op){

		Scanner dis =new Scanner(System.in);

		System.out.println("enter option ("+ (i+1) +")");

		op.setOptionValue(dis.nextLine());


		System.out.println("enter whether this option is correct or not[t/f]");
		String s= dis.nextLine();

		if(s.equals("t")) op.setCorrectAnswer(true);
		else
			op.setCorrectAnswer(false);
	}
}
