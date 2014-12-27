//new
package core.reports;

import domain.tests.Question;
import domain.tests.Test;
import domain.reports.Report;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Evaluation {

	public Report evaluateTest(Test t,String studentName,String testId){

		Report report= new Report();

		int numberOfcorrectAns=0,numberOfwrongAns=0,numberOfParitallyCorrectAns=0;

		float score=0,mark=0;
		for(int i=0;i<t.getTestQuestions().size();i++){
			Question q = t.getTestQuestions().get(i);
			mark= evaluateQuestion(q);
			score=score+mark;
			if(mark==1) numberOfcorrectAns++;
			else if(mark==0) numberOfwrongAns++;
			else numberOfParitallyCorrectAns++;
		}

		if( (score) >= (t.getQualifyingMark()) ){
			report.setResult(true);
		}


		report.setScore(score);
		report.setNumberOfCorrectAns(numberOfcorrectAns);
		report.setNumberOfWrongAns(numberOfwrongAns);
		report.setNumberOfPartiallyCorrect(numberOfParitallyCorrectAns);

		Date d=new Date();
		String s= ((d.getMonth())+ 1) + "/" +d.getDate()+"/"+( (d.getYear())+1900);
		report.setDate(s);

		report.setTotalNumberOfQuestions(t.getTestQuestions().size());

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Reports.txt",true));

			out.write(studentName +",");
			out.write(testId +",");
			out.write( String.valueOf(report.getScore() ) +",");
			out.write( String.valueOf(report.getNumberOfCorrectAns() )+",");
			out.write( String.valueOf(report.getNumberOfWrongAns() )+",");
			out.write( String.valueOf(report.getNumberOfPartiallyCorrect() )+",");
			out.write( String.valueOf(report.getDate() )+",");
			out.write( String.valueOf(report.getTotalNumberOfQuestions())+",");
			out.write( String.valueOf(report.isResult()) );
			out.write("\n");

			out.close();

		} catch (IOException e) {

		}	

		return report;
	}

	public float evaluateQuestion(Question q){
		ArrayList<Integer> userans = new ArrayList<Integer>();

		ArrayList<Integer> crtans= new ArrayList<Integer>();
		for(int i=0;i<q.getNumberOfOptions();i++)
		{
			if( q.getOptions().get(i).isCorrectAnswer())
			{
				crtans.add(q.getOptions().get(i).getOptionNumber());
			}
		}

		String []temp=q.getUserAnswer().split(",");

		for(int i=0;i<temp.length;i++)
		{
			try{

				int a= Integer.parseInt(temp[i]);
				if(!userans.contains(a))
					userans.add(a);
			}
			catch(Exception e){

			}


		} 
		int j=0;float mark=0;
		while(j<userans.size()){
			if(crtans.contains(userans.get(j)))
			{
				j++; 
				mark = mark +((float)1/crtans.size());
			}			 
			else 
			{  
				mark =0;
				break;
			}
		}
		return mark;

	}

	public void displayReport(Report r){
		System.out.println("\t\t\tREPORT");
		System.out.println("Number of Correct Answers: "+r.getNumberOfCorrectAns());
		System.out.println("Number of Partially Correct Answers: "+r.getNumberOfPartiallyCorrect());
		System.out.println("Number of Wrong Answers: "+r.getNumberOfWrongAns());
		System.out.println("Score: "+r.getScore());
		if(r.isResult())
			System.out.println("Result: PASS");
		else
			System.out.println("Result: FAIL");

	}

	public void viewReports(String s){
		int flag=0;
		try {

			BufferedReader in = new BufferedReader(new FileReader("Reports.txt"));

			String str="";
			System.out.println("\t\t\tREPORTS");



			while (true) {


				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");

				if( sName[0].equals(s) ){

					flag=1;

					System.out.print("Date of Exam: "+sName[6]+"\t");
					System.out.print("Test ID: "+sName[1]+"\t");
					System.out.print("Number of Correct Answers: "+sName[3]+"\t");
					System.out.print("Number of Wrong Answers: "+sName[4]+"\t");
					System.out.print("Number Of Partially Correct Answers: "+sName[5]+"\t");
					System.out.print("Total Number of Questions: "+sName[7]+"\t");
					System.out.print("score: "+sName[2]+"\t");
					if(sName[8].equals("true"))
						System.out.println("Result: PASS");
					else
						System.out.println("Result: FAIL");
					System.out.println("\n");
				}

			}

			in.close();
		} catch (Exception e) {	}

		if(flag==0){
			System.out.println("No Reports available");
		}
	}

}
