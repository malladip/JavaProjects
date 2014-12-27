//new
package core.users;

import domain.users.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Authentication {

	public void studentRegister(){  

		Student s=new Student();

		Scanner dis=new Scanner(System.in);
		System.out.println("enter student's name");
		s.setStudentName(dis.nextLine());

		System.out.println("enter student's date of birth (mm/dd/year)");
		String d;
		d=dis.nextLine();
		s.setDateOfBirth(new Date(d));	

		System.out.println("enter student's college name");
		s.setCollegeName(dis.nextLine());

		System.out.println("enter student's qualification");
		s.setQualification(dis.nextLine());

		System.out.println("select user name");

		String uN=selectUserName();
		s.setUserName(uN);

		System.out.println("select password");
		s.setPassword(dis.nextLine());

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("StudentDetails.txt",true));

			BufferedWriter outBW = new BufferedWriter(new FileWriter("ResgisteredStudents.txt",true));

			out.write(s.getUserName()+",");
			out.write(s.getStudentName()+",");
			out.write( ((s.getDateOfBirth().getMonth())+ 1) + "/" + s.getDateOfBirth().getDate()+"/"+( (s.getDateOfBirth().getYear())+1900)+",");
			out.write(s.getCollegeName()+",");
			out.write(s.getQualification());
			out.write("\n");

			out.close();

			outBW.write(s.getUserName()+",");
			outBW.write(s.getPassword());
			outBW.write("\n");

			outBW.close();

		} catch (IOException e) {

		}	


		System.out.println("you have successfully registered");

	}

	public String selectUserName(){

		Scanner dis=new Scanner(System.in);
		String userName=dis.nextLine();

		try {

			BufferedReader in = new BufferedReader(new FileReader("ResgisteredStudents.txt"));

			String str="";
			int flag=0;

			while (true) {

				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");


				if( sName[0].equals(userName) ){
					System.out.println("user name already exists\nselect another user name");
					userName=selectUserName();
					break;
				}

			}
			in.close();

		}			
		catch (IOException e) {	}
		return userName;
	} 

	public void displayStudentDetails(Student s){

		System.out.println("student's name:"+s.getStudentName());
		System.out.println("user name:"+s.getUserName());
		System.out.println("Date of Birth:"+(s.getDateOfBirth().getMonth()+1)+"/"+(s.getDateOfBirth().getDate())+"/"+(s.getDateOfBirth().getYear()+1900));
		System.out.println("college name:"+s.getCollegeName());
		System.out.println("qualifiaction:"+s.getQualification());

	}


	//getStudentDetails based on user name
	public String getStudentDetails(String userName){
		String studentName="";

		try {

			BufferedReader in = new BufferedReader(new FileReader("StudentDetails.txt"));

			String str="";

			while (true) {

				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");

				if( sName[0].equals(userName) ){

					studentName=sName[1];
					break;					
				}

			}
			in.close();
		} catch (IOException e) {	
		}
		return studentName;
	}


	public String studentLogin(){

		Student s= new Student();

		String userName="",password="";

		Scanner dis=new Scanner(System.in);
		System.out.println("enter user name:");

		userName=dis.nextLine();
		System.out.println("enter password:");
		password=dis.nextLine();


		int flag=0;		
		try {

			BufferedReader in = new BufferedReader(new FileReader("ResgisteredStudents.txt"));

			String str="";
			while (true) {


				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");


				if( sName[0].equals(userName) ){

					if(sName[1].equals(password)){

						flag=1;

						s.setUserName(userName);

						break;
					}else{
						System.out.println("incorrect password");
						flag=2;
						userName=studentLogin();
						break;

					}

				}
			}

			if(flag==0){

				System.out.println("user name is invalid");
				userName=studentLogin();
			}

			in.close();
		} catch (IOException e) {	

		}

		return userName;

	}

	public void adminRegister(){

		Admin admin=new Admin();

		Scanner dis=new Scanner(System.in);
		System.out.println("select admin name:");
		String a=dis.nextLine();
		admin.setUserName(a);
		System.out.println("select password ");
		String p=dis.nextLine();
		admin.setPassword(p);


		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("AdminDetails.txt",true));

			out.write(admin.getUserName()+",");
			out.write(admin.getPassword());
			out.write("\n");

			out.close();

		} catch (IOException e) {

		}	

	}

	public int adminLogin(){

		String userName="",password="";

		Scanner dis=new Scanner(System.in);

		System.out.println("enter admin name:");
		userName=dis.nextLine();
		System.out.println("enter password:");
		password=dis.nextLine();

		int flag=0;

		try {

			BufferedReader in = new BufferedReader(new FileReader("AdminDetails.txt"));

			String str="";


			while (true) {


				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");


				if( sName[0].equals(userName) ){

					if(sName[1].equals(password)){


						flag=1;

						break;
					}else{
						System.out.println("incorrect password");
						flag=2;
						flag = adminLogin();
						break;
					}

				}

			}
			if(flag==0){

				System.out.println("user name is invalid");
				flag = adminLogin();
			}
			in.close();

		} catch (IOException e) {	

		}

		return flag;
	}

	public void listOfStudents(){

		try {

			BufferedReader in = new BufferedReader(new FileReader("StudentDetails.txt"));

			String str="";

			System.out.println("List of Students:\n");
			while (true) {

				str = in.readLine();

				if((str==null)) break;

				String [] sName=str.split(",");
				System.out.println(sName[1]);
			}
			in.close();
		} catch (IOException e) {	
		}

	}
}