//new
package core.tests;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import domain.tests.*;

public class ConductTest{

	ArrayList<Question> questions=new ArrayList<Question>();

	List<Integer> a=new ArrayList<Integer>();

	public String generateTestID(){

		int count=0;
		String s ="QZ";
		count= (int) ( ( Math.random() ) *100 );
		s = s + count ;
		return s;

	}

	public void generateRandomNumbers(Test t){

		try
		{
			FileInputStream fis=new FileInputStream("QuestionBank.odt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			questions= (ArrayList<Question>) ois.readObject();
			ois.close();

		} catch(Exception e){
			e.printStackTrace();
		}

		for(int i=0;i<(t.getNumberOfQuestions());i++)
		{
			Integer x=generaterandomnumber(a);
			a.add(x);

		}

	}


	public Integer generaterandomnumber(List<Integer> a){

		Integer y= ( (int)( ( Math.random() ) * (questions.size() )  )  )+1;

		if(a.contains(y)) 

			return generaterandomnumber(a);

		else
			return y;
	}


	public void generateQuestions(Test t){

		for(int i=0;i<t.getNumberOfQuestions();i++)
		{

			Question q=questions.get( ( a.get(i) ) -1);

			printQuestion(q,i);

			getUserAns(q);

			System.out.println("\n");

			t.getTestQuestions().add(q);

		}

	}

	public String getUserAns(Question q){


		ArrayList<Integer> userans = new ArrayList<Integer>();		
		Scanner dis=new Scanner(System.in);

		String ans="";
		System.out.println("\nEnter your answer(s)");
		ans =dis.nextLine();

		if(ans.equals("")) {
			q.setUserAnswer("0");
			return q.getUserAnswer();
		}
		else {
			String []temp=ans.split(",");

			for(int j=0;j<temp.length;j++)
			{
				try{

					int a= Integer.parseInt(temp[j]);
					if(!userans.contains(a))
						userans.add(a);

				}

				catch(NumberFormatException e){
					System.out.println("you have entered a invalid option");
					ans=getUserAns(q);
				}
			}

			q.setUserAnswer(ans);
			return q.getUserAnswer();
		}
	}	

	public void printQuestion(Question q,int j){

		System.out.println("Q"+(j+1)+": "+q.getQuestionDescription());


		for(int i=0;i<q.getNumberOfOptions();i++){

			Option op=(q.getOptions()).get(i);
			printOption(op);
		}
	}

	public void  printOption(Option op)
	{
		System.out.print(op.getOptionNumber()+")");
		System.out.println(" "+op.getOptionValue());
	}

}
