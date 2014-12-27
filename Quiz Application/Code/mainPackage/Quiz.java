
//new
package mainPackage;

import java.io.FileInputStream;

import java.io.ObjectInputStream;
import java.util.Scanner;
import domain.reports.*;
import domain.tests.*;
import core.reports.*;
import core.tests.*;
import core.users.*;

public class Quiz {	

	public static void main(String[] args) {

		Authentication user=new Authentication();

		Scanner dis=new Scanner(System.in);

		int choice=0;
		do{
			try{
				System.out.println("\t\t\t~$ WELCOME 2 QUIZ $~");
				homePageMenu();

				choice=Integer.parseInt(dis.nextLine());

				switch(choice){
				case 1://super admin

					adminOptions(user, dis);
					break;

				case 2://super student
					int ch=0;
					do{
						try{
							studentHomePage();
							ch=Integer.parseInt(dis.nextLine());
							switch(ch){//student outer switch
							case 1:
								studentLogin(user, dis);
								break;
							case 2://register student
								user.studentRegister();
								break;
							case 3:
								break;
							} //outer student switch close
						}
						catch(NumberFormatException n){
							System.out.println("Invalid Choice");

						}
					}while(ch<=2); //outer student while close
					break;//super student case 2 break

				case 3://super close application
					System.out.println("You have exited the system");
					System.exit(0);
				}//super switch
			}//try
			catch(NumberFormatException n){
				System.out.println("Invalid Choice");
			}

		}while(choice<=3);//close super DO


	} //close MAIN

	private static void studentLogin(Authentication user, Scanner dis) {
		String userName=user.studentLogin();

		//	if(flag1==1){
		int option1=0;
		do{	
			try{

				System.out.println("\nYou can");
				System.out.println("1. Take test\n2. View reports\n3. Logout");	

				System.out.println("Enter your choice:");

				option1=Integer.parseInt(dis.nextLine());
				switch(option1){// student inner switch

				case 1:	//take test
					takeTest(user, userName);		
					break;

				case 2://view reports
					//to do
					viewPreviousReports(user, userName);
					break;

				case 3:// log out student
					System.out.println("You have successfully logged out");
					break;
				}//close inner student switch
			}

			catch(NumberFormatException n){
				System.out.println("Invalid Choice");
			}

		}while(option1<=2);//close inner student do
		//						}//close student if
	}

	private static void viewPreviousReports(Authentication user, String userName) {
		Evaluation e1= new Evaluation();
		String studentName1=user.getStudentDetails(userName);
		e1.viewReports(studentName1);
	}

	private static void takeTest(Authentication user, String userName) {
		Test t=new Test();

		try
		{


			FileInputStream fis=new FileInputStream("TestDetails.odt");
			ObjectInputStream ois=new ObjectInputStream(fis);

			t= (Test) ois.readObject();	
			ois.close();

		} catch(Exception e){
			System.out.println("Test details are not available");

		}

		System.out.println("\n\n\n\t\t\t\t--QUIZ--\n\n");
		System.out.println("\tTime: "+t.getTime()+" mins\tQualifying Marks: "+ t.getQualifyingMark()+"\t Max.Marks: "+ t.getNumberOfQuestions()+"\n");

		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		System.out.println("Instructions:\n"+"\tEach Question carries 1 mark\n\tA Question may have MULTIPLE Answers\n\tEnter answer as OPTION NUMBER seperated by comma(,)\n\tPress ENTER for next Question");

		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");


		ConductTest conductTest=new ConductTest();

		conductTest.generateRandomNumbers(t);
		conductTest.generateQuestions(t);

		//to do

		String testID=conductTest.generateTestID();

		Evaluation e = new Evaluation();

		String studentName=user.getStudentDetails(userName);
		Report report=e.evaluateTest(t,studentName,testID);
		e.displayReport(report);
	}

	private static void studentHomePage() {
		System.out.println("\n\t\t\t~~~STUDENT PAGE~~~");
		System.out.println("1. Login\n2. Register\n3. Go to home page");
		System.out.println("Enter your choice: ");
	}

	private static void adminOptions(Authentication user, Scanner dis) {
		System.out.println("\t\t\t~~~LOGIN PAGE~~~");

		int flag=user.adminLogin();

		int option=0;						

		if(flag==1){
			do{  
				try{
					System.out.println("\nYou can");

					System.out.println("1. add questions\n2. Configure Quiz\n3. view students reports\n4. Logout\n");	

					System.out.println("Enter your choice:");


					option=Integer.parseInt(dis.nextLine());
					Configuration config=new Configuration();

					switch(option){ 

					case 1:// adding questions 
						config.createQuestionBank();
						break;
					case 2://Config quiz
						config.setTestDetails();
						break;
					case 3://view reports admin
						Evaluation e = new Evaluation();
						user.listOfStudents();
						System.out.print("\n");
						System.out.println("Enter student's name");
						String s=dis.nextLine();
						System.out.print("\n");
						e.viewReports(s);
						break;
					case 4://log out admin
						System.out.println("You have successfully logged out");
						break;
					} //admin after login switch end
				}	
				catch(NumberFormatException n){
					System.out.println("Invalid Choice");
				}

			}while(option<=3); //close do while in super admin 

		}	//super case 1 close if
	}

	private static void homePageMenu() {
		System.out.println("");
		System.out.println("1. Admin\n2. Student\n3. Exit");

		System.out.println("Enter your choice");
	}
}//close quize CLASS
